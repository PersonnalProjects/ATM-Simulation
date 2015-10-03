package org.projects.spring.atm.simulation.dao;
import org.projects.spring.atm.simulation.domain.CustomerCard;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;


public class JDBCCustomerCardDAO extends SimpleJdbcDaoSupport implements CustomerCardDAO {

	public JDBCCustomerCardDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public CustomerCard getCustomerCard(String customerCardNumber) {	
		try
		{
			logger.info("JDBCCustomerCardDAO : getCustomerCard() - Starting............");
	   
	        String SELECT = " SELECT * "
	                      + " FROM CustomerCard"
	                      + " WHERE cardNumber = :customerCardNumber";
	        
	        Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("customerCardNumber", customerCardNumber);

			logger.info("JDBCCustomerCardDAO : getCustomerCard() - Finishing............");
	        return getSimpleJdbcTemplate().queryForObject(SELECT, new CustomerCardMapper(), parameters);      
		}
		catch (EmptyResultDataAccessException e) 
		{
			
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			String exceptionAsString = sw.toString();

			logger.info("JDBCCustomerCardDAO : getCustomerCard() - Error executing the query. StackTrace: " + exceptionAsString);
			
			return null;
		}
	}

	@Override
	public boolean SaveCustomerCard(CustomerCard customerCard) {
			return true;
    }

    private static class CustomerCardMapper implements ParameterizedRowMapper<CustomerCard> {

        public CustomerCard mapRow(ResultSet rs, int rowNum) throws SQLException {
        	CustomerCard customerCard= new CustomerCard();
        	customerCard.setCardNumber(rs.getString("cardNumber")); 
        	customerCard.setHolderFirstName(rs.getString("holderFirstName")); 
        	customerCard.setHolderLastName(rs.getString("holderLastName")); 
        	customerCard.setNip(rs.getString("nip")); 	
        	customerCard.setAccountNumber(rs.getString("accountNumber"));
            return customerCard;
        }

    }
}


