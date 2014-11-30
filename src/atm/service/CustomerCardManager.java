/**
 * 
 */
package atm.service;

import atm.dao.CustomerCardDAO;
/**
 * @author yves
 *
 */
public class CustomerCardManager {

	private CustomerCardDAO cardDAO;

	public CustomerCardDAO getCardDAO() {
		return cardDAO;
	}

	public void setCardDAO(CustomerCardDAO cardDAO) {
		this.cardDAO = cardDAO;
	}

}
