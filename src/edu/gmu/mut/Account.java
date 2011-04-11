package edu.gmu.mut;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Class Account represents an immutable customer account.
 */
public class Account {

	/** The date of last visit. */
	private Calendar dateOfLastVisit;
	
	/** The name. */
	private String name;
	
	/** The email. */
	private String email;
	
	/** The date registered. */
	private Calendar dateRegistered;
	
	/** The purchase history. */
	private ArrayList purchaseHistory;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Gets the date registered.
	 *
	 * @return the date registered
	 */
	public Calendar getDateRegistered() {
		return dateRegistered;
	}

	/**
	 * Gets the last visit date.
	 *
	 * @return the last visit date
	 */
	public Calendar getLastVisitDate() {
		return dateOfLastVisit;
	}

	/**
	 * Gets the purchase history.
	 *
	 * @return the purchase history
	 */
	public ArrayList getPurchaseHistory() {
		return purchaseHistory;
	}

	
	/**
	 * Instantiates a new account.
	 */
	private Account(){}
	
	/**
	 * Static factory method for creating new instances of Account objects
	 *
	 * @param name the name
	 * @param email the email
	 * @param dateRegistered the date registered
	 * @param lastVisitDate the last visit date
	 * @param purchases the purchases
	 * @return the account
	 */
	public static Account newInstance(String name, String email, Calendar dateRegistered, Calendar lastVisitDate, ArrayList<Purchase> purchases) {
		Account accnt = new Account();
		accnt.name = name;
		accnt.email = email;
		accnt.dateRegistered = dateRegistered;
		accnt.dateOfLastVisit = lastVisitDate;
		accnt.purchaseHistory = purchases;
		return accnt;
	}
	
	
	public String toString(){
		return this.name + ", " + this.email  + ", " + this.getPurchaseHistory().toString(); 
		
	}

}
