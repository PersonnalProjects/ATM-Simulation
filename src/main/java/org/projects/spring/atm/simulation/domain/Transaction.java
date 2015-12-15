/**
 * 
 */
package org.projects.spring.atm.simulation.domain;
import java.io.Serializable;
import org.joda.time.DateTime;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author yves
 *
 */
public abstract class Transaction implements Serializable{

	public static enum transactionType { WITHDRAWAL, DEPOSIT};
	//public static final String deposit = "DEPOSIT";
	//public static final String withdrawal = "WITHDRAWAL";
	//public static final String unknow = "UNKNOW";
	public static final String DEPOSIT_KEY = "deposit.title";
	public static final String WITHDRAWAL_KEY = "withdrawal.title";

	private ResourceBundleMessageSource messageSource;

	private double amount;
	private  Boolean status;
	private String date;
	private transactionType type;
	private String accountNumber;
	
	public Transaction(){;}
	public Transaction(double amount, Boolean status, String date, transactionType type, String accountNumber)
	{
		this.amount = amount;
		this.status = status;
		this.date = date;
		this.setType(type);
		this.accountNumber  = accountNumber;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getType() {

		String transactionTypeString = "";


		/*
		Locale locale = LocaleContextHolder.getLocale();
		messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("/resources/messages");

		transactionTypeString = messageSource.getMessage(DEPOSIT_KEY, new Object[0], locale);
		int a= 0;
		*/

		switch ( type )
		{
			case DEPOSIT: 		transactionTypeString = "DEPOSIT";break;//transactionTypeString = messageSource.getMessage(DEPOSIT_KEY, new Object[0], locale);break;
			case WITHDRAWAL: 	transactionTypeString =  "WITHDRAWAL";break;//transactionTypeString = messageSource.getMessage(WITHDRAWAL_KEY, new Object[0], locale);break;
			default: throw new RuntimeException("Unknow transaction type: " + type.toString());
		}

		return transactionTypeString;
	}

	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setType(transactionType type) {

		/*
		switch(type){
			case DEPOSIT:   	this.type = Transaction.deposit;		break;
			case WITHDRAWAL:   	this.type = Transaction.withdrawal;		break;
			default:			this.type = Transaction.unknow;			break;
		}
		*/

		this.type = type;
	}
	
	
}
