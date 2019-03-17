package com.backbase.api.test;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.backbase.api.model.OpenBankTransData;
import com.backbase.api.model.Transaction;
import com.backbase.api.model.TransactionMapper;
import com.backbase.api.util.Constants;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:backbase-servlet.xml" })
public class ApiTest {

	@Test
	public void test() throws Exception {
		System.out.println("Test is running...");

		Client client = ClientBuilder.newClient();
		String jsonData = client.target(Constants.OPEN_BANK_TRANS_URL).request(MediaType.APPLICATION_JSON)
				.get(String.class);
		Gson gson = new Gson();
		OpenBankTransData trans = gson.fromJson(jsonData, OpenBankTransData.class);

		List<Transaction> transactions = trans.getTransactions().stream().map(TransactionMapper::toBackBase)
				.collect(Collectors.toList());
		client.close();
		assert (transactions.size() > 0);

	}

}
