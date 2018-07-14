package com.dawn.exchangeConsumer.controllers;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.dawn.exchangeConsumer.DBUtil.MongoConnectionUtil;
import com.dawn.exchangeConsumer.QueueUtils.RabbitMQUtills;
import com.dawn.exchangeConsumer.beans.CurrencyTransaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

@Controller
public class CurrencyTransactionController implements CommandLineRunner {

	//Getting the queue name from parameter file
	@Value("${rabbitmq.queuename}")
	private String queueName;
	
	//Getting the collection name from parameter file
	@Value("${mongoDB.collectionname}")
	private String collectionName;
	
	@Autowired
	private MongoConnectionUtil mongoConnectionUtil;
	
	@Override
	public void run(String... args) throws Exception {
		main(args);
	}

	/**
	 * The main method need to execute at startup of the application
	 * This method responsible for listen to RabbitMQ - get messages from the queue
	 * and write it to MongoDB  
	 * @param args
	 * @throws IOException
	 * @throws TimeoutException
	 */
	public void main(String[] args) throws IOException, TimeoutException {
		
		//Get MongoDB connection and database
		MongoDatabase database = mongoConnectionUtil.getDataBaseInstance();
		
		//Get RabbitMQ channel for specific queue name
		Channel channel = RabbitMQUtills.createConnectionRabbitMQ(queueName);

		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
					throws IOException {
				
				String message = new String(body, "UTF-8");

				//Turn the JSON message to valid currencyTransaction Object and add values Hardcoded
				ObjectMapper objectMapper = new ObjectMapper();
				CurrencyTransaction currencyTransaction = objectMapper.readValue(message, CurrencyTransaction.class); 
				currencyTransaction.setCountryName("USA"); //Hardcoded country name
				currencyTransaction.setExchangeRateNIS(3.54); //Hardcoded exchange rate NIS

				//Turn it back to JSON object in order to write it to mongoDB
				message = objectMapper.writeValueAsString(currencyTransaction);

				System.out.println(" [x] Received '" + message + "'");
				System.out.println("writing to MongoDB: " + currencyTransaction.toString());

				//Connect to "transaction" collection in MongoDB
				MongoCollection<Document> collection = database.getCollection(collectionName);

				//Write document to MongoDB
				collection.insertOne(Document.parse(message));

			}
		};
		
		//Invoking queue listener 
		channel.basicConsume(queueName, true, consumer);
    }
	
	
}
