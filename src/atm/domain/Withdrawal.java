/**
 * 
 */
package atm.domain;

/**
 * @author yves
 *
 */
public class Withdrawal extends Transaction {
	
	public Withdrawal(){
		this.setType(Transaction.transactionType.WITHDRAWAL);
	}
	public Withdrawal(double amount, Boolean status, String date,  String accountNumber){
		super( amount,  status,  date,  Transaction.transactionType.WITHDRAWAL,  accountNumber);
	}

}
