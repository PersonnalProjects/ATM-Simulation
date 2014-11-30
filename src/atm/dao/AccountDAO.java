package atm.dao;
import atm.domain.Account;

public interface AccountDAO {

	public Account getAccount(String cardNumber);
	public boolean SaveAccount(Account account);
	
}
