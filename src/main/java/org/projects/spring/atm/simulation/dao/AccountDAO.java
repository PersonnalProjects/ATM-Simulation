package org.projects.spring.atm.simulation.dao;
import org.projects.spring.atm.simulation.domain.Account;

public interface AccountDAO {

	public Account getAccount(String accountNumber);
	public boolean SaveAccount(Account account);
	
}
