/**
 * 
 */
package atm.validator;

import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import atm.dao.CustomerCardDAO;
import atm.service.Connection;
/**
 * @author yves
 *
 */
public class ConnectionValidator implements Validator {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    private CustomerCardDAO customerCardDAO;
    
	public boolean supports(Class clazz) {
        return Connection.class.equals(clazz);
    }
	
    public void validate(Object obj, Errors errors) {
    	Connection conn = (Connection) obj;
    	
    	
        if (conn == null) {
            errors.rejectValue("cardNumber", "error.cardNumber.not-specified", null, "Card Number required");
            errors.rejectValue("nip", "error.nip.not-specified", null, "NIP  required");
        }
        else if(conn.getCardNumber() == null){
        	errors.rejectValue("cardNumber", "error.cardNumber.not-specified", null, "Card Number required");
        }
        else if(conn.getCardNumber().length() < 1){
        	errors.rejectValue("cardNumber",  "error.cardNumber.not-specified", null, "Card Number required");
        }       
        else if(conn.getNip() == null){
        	errors.rejectValue("nip", "error.nip.not-specified", null, "NIP  required");
        }  
        else if(conn.getNip().length() < 1){
        	errors.rejectValue("nip", "error.nip.not-specified", null, "NIP  required");
        }         
    }

	public CustomerCardDAO getCustomerCardDAO() {
		return customerCardDAO;
	}

	public void setCustomerCardDAO(CustomerCardDAO customerCardDAO) {
		this.customerCardDAO = customerCardDAO;
	}
}