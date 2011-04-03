package edu.gmu.mut;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Purchase {
      
	String item;
	double price;
	Calendar purchaseDate;
	
	public Purchase(String item, double price, GregorianCalendar purchaseDate ) {
		this.item = item;
		this.price = price;
		this.purchaseDate = purchaseDate;
	}
	
	public String toString(){
		 return this.item + "," + this.price + "," + DateFormat.getInstance().format(purchaseDate.getTime());
	}

}
