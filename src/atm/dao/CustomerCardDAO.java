package atm.dao;
import atm.domain.CustomerCard;

public interface CustomerCardDAO {

	public CustomerCard getCustomerCard(String cardNumber);
	public boolean SaveCustomerCard(CustomerCard customerCard);
}

