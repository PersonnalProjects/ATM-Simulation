/**
 * 
 */
package org.projects.spring.atm.simulation.domain;

/**
 * @author yves
 *
 */

import java.io.Serializable;
import java.util.Date;

public class CustomerCard implements Serializable {


	private String holderFirstName;
    private String holderLastName;
    private String cardNumber;
    private String nip;
    private Date expirationDate;
    
    private String accountNumber;
    
	

	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}




	public String getHolderFirstName() {
		return holderFirstName;
	}




	public void setHolderFirstName(String holderFirstName) {
		this.holderFirstName = holderFirstName;
	}




	public String getHolderLastName() {
		return holderLastName;
	}




	public void setHolderLastName(String holderLastName) {
		this.holderLastName = holderLastName;
	}




	public String getCardNumber() {
		return cardNumber;
	}




	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}




	public String getNip() {
		return nip;
	}




	public void setNip(String nip) {
		this.nip = nip;
	}




	public Date getExpirationDate() {
		return expirationDate;
	}




	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}


    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("holderFirstName: " + holderFirstName + ";");
        buffer.append("holderLastName: " + holderLastName + ";");
        buffer.append("cardNumber: " + cardNumber + ";");
        buffer.append("nip: " + nip.toString() + ";");
        buffer.append("expirationDate: " + expirationDate.toString());
        return buffer.toString();
    }
}