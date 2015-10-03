package org.projects.spring.atm.simulation.dao;
import org.projects.spring.atm.simulation.domain.Account;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;


public class JDBCAccountDAO extends SimpleJdbcDaoSupport implements AccountDAO {

	public JDBCAccountDAO() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("deprecation")
	@Override
	public Account getAccount(String accountNumber) {
		
		try
		{
			logger.info("JDBCAccountDAO : getAccount() - Starting............");
	   
	        String SELECT = " SELECT id, balance, accountNumber "
	                      + " FROM Account"
	                      + " WHERE accountNumber = :accountNumber";
	        SqlParameterSource namedParameters = new MapSqlParameterSource("accountNumber", accountNumber);
	        
	        logger.info("JDBCAccountDAO : getAccount() - Finishing............");
	        return (Account)getSimpleJdbcTemplate().queryForObject(SELECT, new AccountMapper(), namedParameters);  
		}
		catch (EmptyResultDataAccessException e) 
		{
			return null;
		}        
	}

	@Override
	public boolean SaveAccount(Account account) {
		boolean result = false;
    	try
    	{
	        logger.info("Saving Account for accountNumber: " + account.getAccountNumber());
	        @SuppressWarnings("deprecation")
			int count = getSimpleJdbcTemplate().update(
	            "update Account set balance = :balance where accountNumber = :accountNumber",
	            new MapSqlParameterSource().addValue("balance", account.getBalance())
	                .addValue("accountNumber", account.getAccountNumber()));

	        logger.info("Rows affected: " + count);
	        
	        if(count > 0)
	        	result =  true;

    	}
    	catch(Exception e)
    	{
    		logger.error("Error while Saving the Account. Noting saved... " + e.getMessage());
    	}
    	
    	return result;
    }
	
	
    private static class AccountMapper implements ParameterizedRowMapper<Account> {

        public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        	Account account= new Account();
        	account.setBalance(rs.getDouble("balance")); 
        	account.setAccountNumber((rs.getString("accountNumber")));
            return account;
        }

    }
}


