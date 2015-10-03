/**
 * 
 */
package org.projects.spring.atm.simulation.service;

import org.projects.spring.atm.simulation.dao.CustomerCardDAO;
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
