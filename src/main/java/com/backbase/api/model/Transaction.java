package com.backbase.api.model;

/**
 * 
 * @author shafique
 * This is a simple POJO of Transaction in backbase system
 *
 */
public class Transaction {
	
	private String id;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCounterpartyAccount() {
		return counterpartyAccount;
	}

	public void setCounterpartyAccount(String counterpartyAccount) {
		this.counterpartyAccount = counterpartyAccount;
	}

	public String getCounterpartyName() {
		return counterpartyName;
	}

	public void setCounterpartyName(String counterpartyName) {
		this.counterpartyName = counterpartyName;
	}

	public String getCounterPartyLogoPath() {
		return counterPartyLogoPath;
	}

	public void setCounterPartyLogoPath(String counterPartyLogoPath) {
		this.counterPartyLogoPath = counterPartyLogoPath;
	}

	public Double getInstructedAmount() {
		return instructedAmount;
	}

	public void setInstructedAmount(Double instructedAmount) {
		this.instructedAmount = instructedAmount;
	}

	public String getInstructedCurrency() {
		return instructedCurrency;
	}

	public void setInstructedCurrency(String instructedCurrency) {
		this.instructedCurrency = instructedCurrency;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionCurrency() {
		return transactionCurrency;
	}

	public void setTransactionCurrency(String transactionCurrency) {
		this.transactionCurrency = transactionCurrency;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
