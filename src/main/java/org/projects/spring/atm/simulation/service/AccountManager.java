package org.projects.spring.atm.simulation.service;

import org.apache.commons.logging.Log;
import org.projects.spring.atm.simulation.domain.Account;
import org.projects.spring.atm.simulation.dao.AccountDAO;
import org.apache.commons.logging.LogFactory;

/**
 * @author yves
 *
 */
public class AccountManager {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    private AccountDAO accountDAO;
    
	public Account getAccount(String accountNumber) {
		return accountDAO.getAccount( accountNumber);
	}
	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
    
}