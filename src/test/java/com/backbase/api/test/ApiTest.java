package com.backbase.api.test;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.backbase.api.model.OpenBankTransData;
import com.backbase.api.model.Transaction;
import com.backbase.api.model.TransactionMapper;
import com.backbase.api.rest.controller.RestApiController;
import com.backbase.api.service.OpenBankServiceImpl;
import com.backbase.api.util.Constants;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:backbase-servlet.xml" })
public class ApiTest {
	
	private static final Logger logger = Logger.getLogger(ApiTest.class);

	@Autowired
	RestApiController restApiController;

	/**
	 * 
	 * @throws Exception
	 *             This is to test the openBank API connection
	 */
	@Test
	public void testOpenBankApi() throws Exception {
		
		logger.info("testOpenBankApi is running... ");

		Client client = ClientBuilder.newClient();
		String jsonData = client.target(Constants.OPEN_BANK_TRANS_URL).request(MediaType.APPLICATION_JSON)
				.get(String.class);
		Gson gson = new Gson();
		OpenBankTransData trans = gson.fromJson(jsonData, OpenBankTransData.class);

		List<Transaction> transactions = trans.getTransactions().stream().map(TransactionMapper::toBackBase)
				.collect(Collectors.toList());
		client.close();
		assert (transactions.size() > 0);
		
		logger.info("testOpenBankApi is completed.");

	}

	/**
	 * This is to test /api/v1/transactions
	 */
	@Test
	public void testAPI1() throws Exception {

		logger.info(" testAPI1 is running");

		List<Transaction> transactions = restApiController.getTransactions();
		assert (transactions.size() > 0);
		
		logger.info("testAPI1 is completed. " + transactions.size());

	}

	/**
	 * This is to test /api/v1/transactions/{transactionType}
	 */
	@Test
	public void testAPI2() throws Exception {

		logger.info(" testAPI2 is running");

		List<Transaction> transactions = restApiController.getTransactionsByTransactionType("sandbox-payment");
		assert (transactions.size() > 0);
		
		logger.info("testAPI2 is completed. " + transactions.size());

	}

	/**
	 * This is to test /api/v1/transactionsAmount/{transactionType}
	 */
	@Test
	public void testAPI3() throws Exception {

		logger.info(" testAPI3 is running");

		Double sumOfTransactions = restApiController.getTransactionsAmount("sandbox-payment");
		assert (sumOfTransactions >= 0);
		
		logger.info("testAPI3 is completed. " + sumOfTransactions);

	}

}
