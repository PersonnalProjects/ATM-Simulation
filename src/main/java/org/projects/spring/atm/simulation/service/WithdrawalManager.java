package org.projects.spring.atm.simulation.service;
import org.projects.spring.atm.simulation.dao.TransactionDAO;
/**
 * @author yves
 *
 */
public class WithdrawalManager {
	
	private double amount;
	private TransactionDAO withdrawalDAO;
	

	public TransactionDAO getWithdrawalDAO() {
		return withdrawalDAO;
	}
	public void setWithdrawalDAO(TransactionDAO withdrawalDAO) {
		this.withdrawalDAO = withdrawalDAO;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double newAmount) {
		System.out.println(" Withdrawal MANAGER SETTING AMOUNT: " + amount);
		this.amount = newAmount;
	}

}
