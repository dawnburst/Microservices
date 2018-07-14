package com.dawn.exchangeProducer.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dawn.exchangeProducer.QueueUtils.RabbitMQUtils;
import com.dawn.exchangeProducer.beans.CurrencyTransaction;
import com.dawn.exchangeProducer.enums.CurrencyCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rabbitmq.client.Channel;


@RestController
public class CurrencyTransactionController {
	
	@Value("${rabbitmq.queuename}")
	private String queueName;
	
	/**
	 * This method incharge of handling transaction and passed it to RabitMQ 
	 * It expose Rest API and getting 2 parameters
	 * @param currencyCode currency code from enum list
	 * @param currencyAmount 
	 * @return CurrencyTransaction Json object
	 * @throws IOException
	 * @throws TimeoutException
	 */
	@GetMapping("/sendCurrencyTransaction")
	public CurrencyTransaction sendCurrencyTransaction(@RequestParam(name="currencyCode", required=true) CurrencyCode currencyCode, 
			@RequestParam(name="currencyAmount", required=true) double currencyAmount) throws IOException, TimeoutException {
		
		//Create new transaction object with the relevant parameters
		CurrencyTransaction currencyTransaction = new CurrencyTransaction(currencyCode, currencyAmount, new Date());
		
		//Convert object to JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String message = objectMapper.writeValueAsString(currencyTransaction);
		
		System.out.println("queueName=" + queueName + " message=" + message);
	
		//Create connection and channel to RabitMQ
		Channel channel = RabbitMQUtils.createConnectionRabbitMQ(queueName);
		
		//Send Message to the queue
		channel.basicPublish("", queueName, null, message.getBytes("UTF-8"));
	    System.out.println(" [x] Sent '" + message + "'");

	    channel.close();
		
		//Return JSON transaction 
		return currencyTransaction;
	}
	
}





