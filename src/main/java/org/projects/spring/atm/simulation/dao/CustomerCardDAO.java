package org.projects.spring.atm.simulation.dao;
import org.projects.spring.atm.simulation.domain.CustomerCard;

public interface CustomerCardDAO {

	public CustomerCard getCustomerCard(String cardNumber);
	public boolean SaveCustomerCard(CustomerCard customerCard);
}

