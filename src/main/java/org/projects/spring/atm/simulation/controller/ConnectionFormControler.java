/**
 * 
 */
package org.projects.spring.atm.simulation.controller;

/**
 * @author yves
 *
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.projects.spring.atm.simulation.dao.CustomerCardDAO;
import org.projects.spring.atm.simulation.domain.CustomerCard;
import org.projects.spring.atm.simulation.service.CustomerCardManager;
import org.projects.spring.atm.simulation.service.Connection;

@SuppressWarnings("deprecation")
public class ConnectionFormControler extends SimpleFormController {
	
    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

    private CustomerCardDAO customerCardDAO;

    @Override
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object obj, BindException errors)throws ServletException, NoSuchAlgorithmException{
    	
    	logger.info("ConnectionFormControler : onSubmit() - Starting............");
    	
        MessageDigest md = MessageDigest.getInstance("MD5");
        Connection connectionForm = (Connection) obj;
        CustomerCard card = customerCardDAO.getCustomerCard(connectionForm.getCardNumber() );
       
        if (card == null) {

            return new ModelAndView( new RedirectView("login.htm"));
        }      
        
        // nip verification. MD5 digest of the form should be equal to the digest in the BD
        byte connectionFormDigest[] = md.digest( connectionForm.getNip().toString().getBytes());
        if( !card.getNip().equals(  convertByteArrayToHexString(connectionFormDigest)) ) {
        	
            return new ModelAndView( new RedirectView("login.htm"));
        }
        
        HttpSession session = request.getSession();
        session.setAttribute(Connection.ATT_CARD_NUMBER, card.getCardNumber());
        session.setAttribute(Connection.ATT_ACCOUNT_NUMBER, card.getAccountNumber());
        session.setAttribute(Connection.ATT_HOLDER_FIRST_NAME, card.getHolderFirstName());
        session.setAttribute(Connection.ATT_HOLDER_LAST_NAME, card.getHolderLastName());                  
 
        logger.info("ConnectionFormControler : onSubmit() - Finishing............");      
        return new ModelAndView((new RedirectView(getSuccessView())));
    }

	public CustomerCardDAO getCustomerCardDAO() {
		return customerCardDAO;
	}

	public void setCustomerCardDAO(CustomerCardDAO customerCardDAO) {
		this.customerCardDAO = customerCardDAO;
	}
	private static String convertByteArrayToHexString(byte[] arrayBytes) {
	    StringBuffer stringBuffer = new StringBuffer();
	    for (int i = 0; i < arrayBytes.length; i++) {
	        stringBuffer.append(Integer.toString((arrayBytes[i] & 0xff) + 0x100, 16)
	                .substring(1));
	    }
	    return stringBuffer.toString();
	}
}