/**
 * 
 */
package atm.domain;
import java.io.Serializable;
import org.joda.time.DateTime;
/**
 * @author yves
 *
 */
public abstract class Transaction implements Serializable{

	public static enum transactionType { WITHDRAWAL, DEPOSIT};
	public static final String deposit = "DEPOSIT";
	public static final String withdrawal = "WITHDRAWAL";
	public static final String unknow = "UNKNOW";
	
	private double amount;
	private  Boolean status;
	private String date;
	private String type;
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
		return type;
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
		switch(type){
			case DEPOSIT:   	this.type = Transaction.deposit;		break;
			case WITHDRAWAL:   	this.type = Transaction.withdrawal;		break;
			default:			this.type = Transaction.unknow;			break;
		}
	}
	
	
}
