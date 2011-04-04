package edu.gmu.mut;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Purchase {
      
	String item;
	BigDecimal price;
	Calendar purchaseDate;
	
	public Purchase(String item, BigDecimal price, GregorianCalendar purchaseDate ) {
		this.item = item;
		this.price = price;
		this.purchaseDate = purchaseDate;
	}
	
	public String toString(){
		String formattedPrice = NumberFormat.getCurrencyInstance().format(this.price.doubleValue());
		return this.item + "," + formattedPrice + "," + DateFormat.getInstance().format(purchaseDate.getTime());
	}

}
