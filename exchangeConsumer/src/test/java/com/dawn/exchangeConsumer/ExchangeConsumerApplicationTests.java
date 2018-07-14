package com.dawn.exchangeConsumer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {"rabbitmq.queuename=transactionQueueTest", "mongoDB.collectionname=transactionTest" })
public class ExchangeConsumerApplicationTests {

	@Test
	public void contextLoads() {
	}

}
