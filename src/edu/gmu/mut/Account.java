package edu.gmu.mut;

import java.util.ArrayList;
import java.util.Calendar;

public class Account {

	private Calendar dateOfLastVisit;
	private String name;
	private String email;
	private Calendar dateRegistered;
	private ArrayList<Purchase> purchaseHistory;

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Calendar getDateRegistered() {
		return dateRegistered;
	}

	public Calendar getLastVisitDate() {
		return dateOfLastVisit;
	}

	public ArrayList<Purchase> getPurchaseHistory() {
		return purchaseHistory;
	}

	
	private Account(){}
	
	public static Account newInstance(String name, String email, Calendar dateRegistered, Calendar lastVisitDate, ArrayList<Purchase> purchases) {
		Account accnt = new Account();
		accnt.name = name;
		accnt.email = email;
		accnt.dateRegistered = dateRegistered;
		accnt.dateOfLastVisit = lastVisitDate;
		accnt.purchaseHistory = purchases;
		return accnt;
	}

}
