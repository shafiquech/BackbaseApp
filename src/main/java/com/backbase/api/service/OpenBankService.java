package com.backbase.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backbase.api.model.TransactionMapper;
import com.backbase.api.model.OpenBankTransData;
import com.backbase.api.model.Transaction;
import com.backbase.api.util.Constants;
import com.google.gson.Gson;
/**
 * 
 * @author shafique
 *
 */
@Service
public class OpenBankService {

	private List<Transaction> transactions = new ArrayList<>();
	
	/**
	 * 
	 * @return List of transaction
	 */
	public List<Transaction> getTransactions() {

		return transactions;

	}

	/**
	 * to fetch all the data at the application load
	 */
	@PostConstruct
	private void loadTransFromOpenBank() {

		Client client = ClientBuilder.newClient();
		String jsonData = client.target(Constants.OPEN_BANK_TRANS_URL).request(MediaType.APPLICATION_JSON)
				.get(String.class);
		Gson gson = new Gson();
		OpenBankTransData trans = gson.fromJson(jsonData, OpenBankTransData.class);
		
		this.transactions = trans.getTransactions().stream().map(TransactionMapper::toBackBase).collect(Collectors.toList());
		client.close();
	}

}
