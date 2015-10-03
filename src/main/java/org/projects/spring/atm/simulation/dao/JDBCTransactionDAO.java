package org.projects.spring.atm.simulation.dao;
import org.projects.spring.atm.simulation.domain.Transaction;
import org.projects.spring.atm.simulation.domain.Deposit;
import org.projects.spring.atm.simulation.domain.Withdrawal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;


public class JDBCTransactionDAO extends SimpleJdbcDaoSupport implements TransactionDAO {

	public JDBCTransactionDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Transaction CreateTransaction(double amount_, Boolean status_, String date_, String type_, String accountNumber_) {
		
		logger.info("JDBCTransactionDAO : CreateTransaction() - Starting............");
		Transaction transaction;
		if( Transaction.deposit.equalsIgnoreCase( type_))
			transaction = this.createDeposit( amount_,  status_,  date_,  accountNumber_ );
		else 
			transaction = this.createWithdrawal( amount_,  status_,  date_,  accountNumber_ );
		
		logger.info("JDBCTransactionDAO : CreateTransaction() - Finishing............");
		return transaction;
	}
	
	private Transaction createDeposit(double amount_, Boolean status_, String date_, String accountNumber_)
	{
		Deposit transaction = new Deposit( amount_,  status_,  date_,  accountNumber_ );
		return transaction;
	}
	private Transaction createWithdrawal(double amount_, Boolean status_, String date_, String accountNumber_)
	{
		Withdrawal transaction = new Withdrawal( amount_,  status_,  date_,  accountNumber_ );
		return transaction;
	}	
	
	@Override
	public List<Transaction> getTransactions( String accountNumber) {
		
		logger.info("JDBCTransactionDAO : getTransactions() - Starting............");

        String SELECT = " SELECT * "
                + " FROM TransactionTbl"
        	    + " WHERE accountNumber = :accountNumber";

        Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("accountNumber", accountNumber);
		
		logger.info("JDBCTransactionDAO : getTransactions() - Finishing............");
        	  return getSimpleJdbcTemplate().query(SELECT, new TransactionMapper(), parameters);        
	}

	@Override
	public boolean SaveTransaction(Transaction transaction) {
		boolean result = false;
    	try
    	{	
    		logger.info("JDBCTransactionDAO : SaveTransaction() - Starting............");

	        String sql =   "INSERT INTO transactiontbl (amount,  status,  transactionType,  transactionDate, accountNumber)"+"VALUES(?, ?, ?, ?,?)";
	        Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("amount", transaction.getAmount());
			parameters.put("status", transaction.getStatus());
			parameters.put("transactionType", transaction.getType());	        
			parameters.put("transactionDate", transaction.getDate());
			parameters.put("accountNumber", transaction.getAccountNumber());

			//SqlParameterSource namedParameters = new MapSqlParameterSource("accountNumber", accountNumber);
			
			
			String query = "INSERT INTO transactiontbl (amount,  status,  transactionType,  transactionDate, accountNumber) VALUES (:amount,:status,:transactionType,:transactionDate,:accountNumber)";
			Map<String, Object> namedParameters = new HashMap<String, Object>();
			namedParameters.put("amount", transaction.getAmount());
			namedParameters.put("status", transaction.getStatus());
			namedParameters.put("transactionType", transaction.getType());	        
			namedParameters.put("transactionDate", transaction.getDate());
			namedParameters.put("accountNumber", transaction.getAccountNumber());			
			int count = getSimpleJdbcTemplate().update(query, namedParameters);
						
			
			logger.info("JDBCTransactionDAO : SaveTransaction() - Rows affected: " + count);
	        if(count > 0)
	        	result = true;
    	}
    	catch(Exception e)
    	{
    		logger.error("JDBCTransactionDAO : SaveTransaction() - Error while Saving the Transaction. Noting saved... " + e.getMessage());
    	}
    	
    	logger.info("JDBCTransactionDAO : SaveTransaction() - Finishing............");
    	return result;
    }
	

    private static class TransactionMapper implements ParameterizedRowMapper<Transaction> {

        public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
        	
        	Transaction transaction;
        	if( "DEPOSIT".equalsIgnoreCase(rs.getString("transactionType")))
        		transaction = new Deposit();
        	else
        		transaction = new Withdrawal();
        	
        	transaction.setAccountNumber(rs.getString("accountNumber")); 
        	transaction.setAmount(rs.getDouble("amount")); 
        	transaction.setDate(rs.getString("transactionDate"));
        	transaction.setStatus(rs.getBoolean("status"));       	
            return transaction;
        }
    }

}


