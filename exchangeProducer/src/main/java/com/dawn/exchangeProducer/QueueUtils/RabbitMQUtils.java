package com.dawn.exchangeProducer.QueueUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class RabbitMQUtils {

	private final static String HOST = "localhost";

	/**
	 * createConnectionRabbitMQ method creates new connection to RabbitMQ and connect to
	 * the channel of the queue
	 * @param queueName
	 * @return channel of the queue
	 * @throws IOException
	 * @throws TimeoutException
	 */
	public static Channel createConnectionRabbitMQ (String queueName) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost(HOST);
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();
	    channel.queueDeclare(queueName, false, false, false, null);
		return channel;
	}
	
}
