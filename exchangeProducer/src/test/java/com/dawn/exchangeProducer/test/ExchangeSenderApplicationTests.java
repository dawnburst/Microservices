package com.dawn.exchangeProducer.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * @author SHAHARZ
 *
 * ExchangeSenderApplicationTests will run tests cases for testing rest api + functionality
 * rabbitmq.queuename is the name of the queue RabitMQ will use for the tests (it is different from the real
 * queue name of the application)
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"rabbitmq.queuename=transactionQueueTest" })
public class ExchangeSenderApplicationTests {

	@Test
	public void contextLoads() {
	}

}
