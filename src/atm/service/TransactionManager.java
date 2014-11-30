/**
 * 
 */
package atm.service;
import java.util.List;

import atm.domain.Transaction;
import atm.dao.TransactionDAO;
/**
 * @author yves
 *
 */
public class TransactionManager {
	
	//private List<Transaction> transactions;
	private TransactionDAO transactionDAO;


	public List<Transaction> getTransactions( String cardNumber) {
		return transactionDAO.getTransactions(cardNumber);
	}

	public void setTransactionDAO(TransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO;
	}
	
}
