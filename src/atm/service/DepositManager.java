package atm.service;
import atm.domain.Deposit;
import atm.dao.TransactionDAO;
/**
 * @author yves
 *
 */
public class DepositManager {
	
	private double amount;
	public TransactionDAO depositDAO;
	

	public TransactionDAO getDepositDAO() {
		return depositDAO;
	}
	public void setDepositDAO(TransactionDAO depositDAO) {
		this.depositDAO = depositDAO;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double newAmount) {
		System.out.println(" DEPOSIT MANAGER SETTING AMOUNT: " + amount);
		this.amount = newAmount;
	}

}
