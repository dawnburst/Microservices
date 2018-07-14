package com.dawn.exchangeConsumer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dawn.exchangeConsumer.controllers.CurrencyTransactionController;

public class TestExchangeConsumerLogic extends ExchangeConsumerApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	CurrencyTransactionController currencyTransactionController;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testGetTransaction() throws Exception {
		currencyTransactionController.main(null);
	}
	
}
