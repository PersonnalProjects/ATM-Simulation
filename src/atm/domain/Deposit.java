/**
 * 
 */
package atm.domain;


/**
 * @author yves
 *
 */
public class Deposit extends Transaction{
	
	public Deposit(){
		this.setType(Transaction.transactionType.DEPOSIT);;
		}
	public Deposit(double amount, Boolean status, String date,  String accountNumber){
		super( amount,  status,  date,  Transaction.transactionType.DEPOSIT,  accountNumber);
	}
	
}
