package com.backbase.api.model;

import lombok.Data;

@Data
public class Transaction {

	private Long id;
	private String accountId;
	private String counterpartyAccount;
	private String counterpartyName;
	private String counterPartyLogoPath;
	private Double instructedAmount;
	private String instructedCurrency;
	private Double transactionAmount;
	private String transactionCurrency;
	private String transactionType;
	private String description;
	
	
}
