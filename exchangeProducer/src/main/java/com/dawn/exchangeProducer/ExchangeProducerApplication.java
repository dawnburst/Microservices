package com.dawn.exchangeProducer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@SpringBootApplication
public class ExchangeProducerApplication {
	public static void main(String[] args) throws IOException, TimeoutException {
	    SpringApplication.run(ExchangeProducerApplication.class, args);
	}
}
