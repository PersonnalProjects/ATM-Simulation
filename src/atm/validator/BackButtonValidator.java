/**
 * 
 */
package atm.validator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import atm.service.BackButton;


/**
 * @author yves
 *
 */

public class BackButtonValidator implements Validator {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

	public boolean supports(Class clazz) {
        return BackButton.class.equals(clazz);
    }

    public void validate(Object obj, Errors errors) {
    	BackButton backButton = (BackButton) obj;
    	
    	
        if (backButton == null){
        	logger.info("request not from backButton, we stay in the transactions history page");
            errors.rejectValue("backButton", "error.not-specified", null, "Value required.");
        }
        else
        	logger.info("request comming from backButton, we go back to  in transactions panel page");
    }
}