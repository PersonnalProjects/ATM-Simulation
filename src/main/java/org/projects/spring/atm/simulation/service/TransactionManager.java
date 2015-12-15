/**
 * 
 */
package org.projects.spring.atm.simulation.service;
import java.util.List;

import org.projects.spring.atm.simulation.domain.Transaction;
import org.projects.spring.atm.simulation.dao.TransactionDAO;
/**
 * @author yves
 *
 */
public class TransactionManager {
	
	//private List<Transaction> transactions;
	private TransactionDAO transactionDAO;


	public List<Transaction> getTransactions( String accountNumber) {
		return transactionDAO.getTransactions(accountNumber);
	}

	public void setTransactionDAO(TransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO;
	}
	
}
