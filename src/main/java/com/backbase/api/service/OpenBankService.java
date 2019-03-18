package com.backbase.api.service;

import java.util.List;

import com.backbase.api.model.Transaction;

public interface OpenBankService {

	/**
	 * 
	 * @return List of transaction
	 */
	List<Transaction> getTransactions();

}