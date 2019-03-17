package com.backbase.api.model;

/**
 * 
 * @author shafique
 *
 */
public class TransactionMapper {

	/**
	 * 
	 * @param obt
	 * @return Transaction
	 */
	public static Transaction toBackBase(OpenBankTransaction obt) {
		Transaction t = new Transaction();
		t.setId(obt.getId());
		t.setAccountId(obt.getThis_account().getId());
		t.setCounterpartyAccount(obt.getOther_account().getNumber());
		t.setCounterpartyName(obt.getOther_account().getHolder().getName());
		t.setCounterPartyLogoPath(obt.getOther_account().getMetadata().getImage_URL());
		t.setInstructedAmount(Double.valueOf(obt.getDetails().getValue().getAmount()));
		t.setTransactionAmount(Double.valueOf(obt.getDetails().getValue().getAmount()));
		t.setInstructedCurrency(obt.getDetails().getValue().getCurrency());
		t.setTransactionCurrency(obt.getDetails().getValue().getCurrency());
		t.setTransactionType(obt.getDetails().getType());
		t.setDescription(obt.getDetails().getDescription());
		return t;
	}

}
