package com.dawn.exchangeProducer.test;

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

public class TestWebApp extends ExchangeSenderApplicationTests{

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	/**
	 * Testing api layer by passing parameters to the rest url
	 * It should move it to the RabbitMq queue (For testing it create it own testing channel)
	 * @throws Exception
	 */
	@Test
	public void testTransaction() throws Exception {
		mockMvc.perform(get("/sendCurrencyTransaction?currencyCode=TST&currencyAmount=1")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json;charset=UTF-8"))
		.andExpect(jsonPath("$.currencyCode").value("TST")).andExpect(jsonPath("$.currencyAmount").value("1"));
	}
	
}
