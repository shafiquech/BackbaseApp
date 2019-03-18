package com.backbase.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
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
public class OpenBankServiceImpl implements OpenBankService {
	
	private static final Logger logger = Logger.getLogger(OpenBankServiceImpl.class);

	private List<Transaction> transactions = new ArrayList<>();
	
	/**
	 * To get all the pre-populated open-bank transactions
	 */
	@Override
	public List<Transaction> getTransactions() {

		logger.info("getTransactions is called ");
		
		return transactions;

	}

	/**
	 * to fetch all the data at the application load
	 */
	@PostConstruct
	private void loadTransFromOpenBank() {

		// open a rest client
		Client client = ClientBuilder.newClient();
		// get data in Json form
		String jsonData = client.target(Constants.OPEN_BANK_TRANS_URL).request(MediaType.APPLICATION_JSON)
				.get(String.class);
		// Covert to java objects
		Gson gson = new Gson();
		OpenBankTransData trans = gson.fromJson(jsonData, OpenBankTransData.class);
		// finally map it to backbase data stucture, please see TransactionMapper.toBackBase for details
		this.transactions = trans.getTransactions().stream().map(TransactionMapper::toBackBase).collect(Collectors.toList());
		client.close();
	}

}
