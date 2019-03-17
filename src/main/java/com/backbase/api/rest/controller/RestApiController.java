package com.backbase.api.rest.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.backbase.api.model.Transaction;
import com.backbase.api.service.OpenBankService;

@RestController
@RequestMapping("/api/v1/")
public class RestApiController {

	@Autowired
	OpenBankService openBankService;
	
	@RequestMapping(value = "transactions", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Transaction> getTransactions() {
		return openBankService.getTransactions();
	}

	@RequestMapping(value = "transactions/{transactionType}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Transaction> getTransactionsByTransactionType(@PathVariable String transactionType) {
		return openBankService.getTransactions().stream()
				.filter(x -> transactionType.equalsIgnoreCase(x.getTransactionType())).collect(Collectors.toList());
	}

	@RequestMapping(value = "transactionsAmount/{transactionType}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Double getTransactionsAmount(@PathVariable String transactionType) {
		return openBankService.getTransactions().stream()
				.filter(x -> transactionType.equalsIgnoreCase(x.getTransactionType()))
				.collect(Collectors.summarizingDouble(Transaction::getTransactionAmount)).getSum();
	}

}