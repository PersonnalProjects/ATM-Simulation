package atm.dao;
import java.util.List;

import atm.domain.Transaction;

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
