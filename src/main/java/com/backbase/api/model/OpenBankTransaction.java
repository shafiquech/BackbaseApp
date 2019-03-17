package com.backbase.api.model;

import java.util.ArrayList;


public class OpenBankTransaction {
	private String id;
	private ThisAccount this_account;
	private OtherAccount other_account;
	private Details details;
	private Metadata metadata;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

	public ThisAccount getThis_account() {
		return this_account;
	}

	public void setThis_account(ThisAccount this_account) {
		this.this_account = this_account;
	}

	public OtherAccount getOther_account() {
		return other_account;
	}

	public void setOther_account(OtherAccount other_account) {
		this.other_account = other_account;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

}

class Metadata {
	private String narrative = null;
	ArrayList<Object> comments = new ArrayList<Object>();
	ArrayList<Object> tags = new ArrayList<Object>();
	ArrayList<Object> images = new ArrayList<Object>();
	private String where = null;

	// Getter Methods

	public String getNarrative() {
		return narrative;
	}

	public String getWhere() {
		return where;
	}

	// Setter Methods

	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}

	public void setWhere(String where) {
		this.where = where;
	}
}

class Image {

}

class Details {
	private String type;
	private String description;
	private String posted;
	private String completed;
	private New_balance new_balance;
	private Value value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPosted() {
		return posted;
	}

	public void setPosted(String posted) {
		this.posted = posted;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	public New_balance getNew_balance() {
		return new_balance;
	}

	public void setNew_balance(New_balance new_balance) {
		this.new_balance = new_balance;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

}

class Value {
	private String currency;
	private String amount;

	// Getter Methods

	public String getCurrency() {
		return currency;
	}

	public String getAmount() {
		return amount;
	}

	// Setter Methods

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}

class New_balance {
	private String currency;
	private String amount = null;

	// Getter Methods

	public String getCurrency() {
		return currency;
	}

	public String getAmount() {
		return amount;
	}

	// Setter Methods

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}

class Bank {
	private String national_identifier;
	private String name;

	// Getter Methods

	public String getNational_identifier() {
		return national_identifier;
	}

	public String getName() {
		return name;
	}

	// Setter Methods

	public void setNational_identifier(String national_identifier) {
		this.national_identifier = national_identifier;
	}

	public void setName(String name) {
		this.name = name;
	}
}

class Holder {
	private String name;
	private boolean is_alias;

	// Getter Methods

	public String getName() {
		return name;
	}

	public boolean getIs_alias() {
		return is_alias;
	}

	// Setter Methods

	public void setName(String name) {
		this.name = name;
	}

	public void setIs_alias(boolean is_alias) {
		this.is_alias = is_alias;
	}
}

class ThisAccount {
	private String id;
	private ArrayList<Holder> holders = new ArrayList<Holder>();
	private String number;
	private String kind;
	private String IBAN = null;
	private String swift_bic = null;
	private Bank bank;


	// Getter Methods

	public String getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public String getKind() {
		return kind;
	}

	public String getIBAN() {
		return IBAN;
	}

	public String getSwift_bic() {
		return swift_bic;
	}

	public Bank getBank() {
		return bank;
	}

	// Setter Methods

	public void setId(String id) {
		this.id = id;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public void setIBAN(String IBAN) {
		this.IBAN = IBAN;
	}

	public void setSwift_bic(String swift_bic) {
		this.swift_bic = swift_bic;
	}

	public void setBank(Bank bankObject) {
		this.bank = bankObject;
	}


	public ArrayList<Holder> getHolders() {
		return holders;
	}

	public void setHolders(ArrayList<Holder> holders) {
		this.holders = holders;
	}

}

class OtherAccount{

	private String id;
	private Holder holder;
	private String number;
	private String kind;
	private String IBAN = null;
	private String swift_bic = null;
	private Bank bank;
	private AccountMetadata metadata;

	// Getter Methods

	public String getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public String getKind() {
		return kind;
	}

	public String getIBAN() {
		return IBAN;
	}

	public String getSwift_bic() {
		return swift_bic;
	}

	public Bank getBank() {
		return bank;
	}

	// Setter Methods

	public void setId(String id) {
		this.id = id;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public void setIBAN(String IBAN) {
		this.IBAN = IBAN;
	}

	public void setSwift_bic(String swift_bic) {
		this.swift_bic = swift_bic;
	}

	public void setBank(Bank bankObject) {
		this.bank = bankObject;
	}

	public AccountMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(AccountMetadata metadata) {
		this.metadata = metadata;
	}

	public Holder getHolder() {
		return holder;
	}

	public void setHolder(Holder holder) {
		this.holder = holder;
	}

	


}

class AccountMetadata {

	private String public_alias;
	private String private_alias;
	private String more_info;
	private String URL;
	private String image_URL;
	private String open_corporates_URL;
	private String corporate_location;
	private String physical_location;
	public String getPublic_alias() {
		return public_alias;
	}
	public void setPublic_alias(String public_alias) {
		this.public_alias = public_alias;
	}
	public String getPrivate_alias() {
		return private_alias;
	}
	public void setPrivate_alias(String private_alias) {
		this.private_alias = private_alias;
	}
	public String getMore_info() {
		return more_info;
	}
	public void setMore_info(String more_info) {
		this.more_info = more_info;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getImage_URL() {
		return image_URL;
	}
	public void setImage_URL(String image_URL) {
		this.image_URL = image_URL;
	}
	public String getOpen_corporates_URL() {
		return open_corporates_URL;
	}
	public void setOpen_corporates_URL(String open_corporates_URL) {
		this.open_corporates_URL = open_corporates_URL;
	}
	public String getCorporate_location() {
		return corporate_location;
	}
	public void setCorporate_location(String corporate_location) {
		this.corporate_location = corporate_location;
	}
	public String getPhysical_location() {
		return physical_location;
	}
	public void setPhysical_location(String physical_location) {
		this.physical_location = physical_location;
	}
	
	
}
