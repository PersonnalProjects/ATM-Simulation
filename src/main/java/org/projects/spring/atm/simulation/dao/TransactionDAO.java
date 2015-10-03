package org.projects.spring.atm.simulation.dao;
import java.util.List;

import org.projects.spring.atm.simulation.domain.Transaction;

public interface TransactionDAO {

	public double amount=Double.NaN;
	public  Boolean status=null;
	public String date=null;
	public String type=null;
	public String accountNumber=null;
	
	public List<Transaction> getTransactions(String accountNumber);
	public boolean SaveTransaction(Transaction transaction);
	public Transaction CreateTransaction(double amount, Boolean status, String date, String type, String accountNumber);

}
