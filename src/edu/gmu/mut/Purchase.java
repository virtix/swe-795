package edu.gmu.mut;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Class Purchase, represents a single purchase made buy a customer.
 */
public class Purchase {
      
	/** The item. */
	final String item;
	
	/** The price. */
	final BigDecimal price;
	
	/** The purchase date. */
	final Calendar purchaseDate;
	
	/**
	 * Instantiates a new purchase.
	 *
	 * @param item the item
	 * @param price the price
	 * @param marchDate the purchase date
	 */
	public Purchase(String item, BigDecimal price, Calendar marchDate ) {
		this.item = item;
		this.price = price;
		this.purchaseDate = marchDate;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		String formattedPrice = NumberFormat.getCurrencyInstance().format(this.price.doubleValue());
		return this.item + "," + formattedPrice + "," + DateFormat.getInstance().format(purchaseDate.getTime());
	}

}
