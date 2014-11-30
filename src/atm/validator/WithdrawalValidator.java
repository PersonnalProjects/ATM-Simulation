/**
 * 
 */
package atm.validator;


/**
 * @author yves
 *
 */

import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import atm.dao.AccountDAO;
import atm.dao.TransactionDAO;
import atm.service.WithdrawalManager;

public class WithdrawalValidator implements Validator {
    private int DEFAULT_MIN_AMOUNT = 20;
    private int DEFAULT_MAX_AMOUNT = 500;
    
	private int minAmount = DEFAULT_MIN_AMOUNT;
    private int maxAmount = DEFAULT_MAX_AMOUNT;
    
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    private AccountDAO accountDAO;
    private TransactionDAO transactionDAO;
    
    public TransactionDAO getTransactionDAO() {
		return transactionDAO;
	}

	public void setTransactionDAO(TransactionDAO transactionDAO) {
		this.transactionDAO = transactionDAO;
	}

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

    

	public boolean supports(Class clazz) {
        return WithdrawalManager.class.equals(clazz);
    }

    public void validate(Object obj, Errors errors) {
    	WithdrawalManager withdrawalForm = (WithdrawalManager) obj;
        if (withdrawalForm == null) {
            errors.rejectValue("amount", "error.withdrawal.not-specified", null, "An amount is required");
        }
        else if( withdrawalForm.getAmount() == 0.0){
        	errors.rejectValue("amount","error.withdrawal.null", null, "A not null amount is required");
        }
        else
        {
            logger.info("Making a withdrawal of:  " + withdrawalForm.getAmount());
            if (withdrawalForm.getAmount() > this.maxAmount) {
                errors.rejectValue("amount", "error.too-high",
                    new Object[] {new Integer(this.maxAmount)}, "Value too high.");
            }
            else if (withdrawalForm.getAmount() < this.minAmount) {
                errors.rejectValue("amount", "error.too-low",
                    new Object[] {new Integer(this.minAmount)}, "Value too low.");
            }
        }   
    }

    public int getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(int minAmount) {
		this.minAmount = minAmount;
	}

	public int getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(int maxAmount) {
		this.maxAmount = maxAmount;
	}
}