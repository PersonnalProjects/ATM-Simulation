package org.projects.spring.atm.simulation.domain;
import java.io.Serializable;
import org.joda.time.DateTime;
/**
 * @author yves
 *
 */
public class Account implements Serializable{

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	private double balance;
	private  String accountNumber;


	
}
