/**
 * 
 */
package org.projects.spring.atm.simulation.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author yves
 *
 */
public class Connection {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	public static final String ATT_CARD_NUMBER = "card_number_attribute";
	public static final String ATT_ACCOUNT_NUMBER = "account_number_attribute";
	public static final String ATT_HOLDER_FIRST_NAME = "holder_first_name";
	public static final String ATT_HOLDER_LAST_NAME = "holder_last_name";
	
	private String cardNumber;
    private String nip;
    
    
    public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
        logger.info("cardNumber set to " + cardNumber);
	}

	public String getNip() {
		return nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
        logger.info("nip set to " + nip);
	}
}
