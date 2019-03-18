package com.backbase.api.rest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backbase.api.model.Transaction;
import com.backbase.api.service.OpenBankService;
import com.backbase.api.service.OpenBankServiceImpl;

@RestController
@RequestMapping("/api/v1/")
public class RestApiController {
	
	private static final Logger logger = Logger.getLogger(RestApiController.class);

	@Autowired
	OpenBankService openBankService;
	
	@RequestMapping(value = "transactions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> getTransactions() {
		logger.info("getTransactions is called");
		
		return openBankService.getTransactions();
	}

	@RequestMapping(value = "transactions/{transactionType}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Transaction> getTransactionsByTransactionType(@PathVariable String transactionType) {
		
		logger.info("getTransactionsByTransactionType is called the transactionType is "+ transactionType);
		
		return openBankService.getTransactions().stream()
				.filter(x -> transactionType.equalsIgnoreCase(x.getTransactionType())).collect(Collectors.toList());
	}

	@RequestMapping(value = "transactionsAmount/{transactionType}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Double getTransactionsAmount(@PathVariable String transactionType) {
		
		logger.info("getTransactionsAmount is called the transactionType is "+ transactionType);
		
		return openBankService.getTransactions().stream()
				.filter(x -> transactionType.equalsIgnoreCase(x.getTransactionType()))
				.collect(Collectors.summarizingDouble(Transaction::getTransactionAmount)).getSum();
	}

}