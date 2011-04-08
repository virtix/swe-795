package edu.gmu.mut;

import java.math.BigDecimal;
import java.util.Calendar;

// TODO: Auto-generated Javadoc
/**
 * The Interface Discount.
 */
public abstract class Discount {

	/**
	 * Gets the discount.
	 *
	 * @param account the account
	 * @param startDate the start date
	 * @return the discount
	 */
	public static BigDecimal getDiscount(Account account, Calendar startDate){
		new Throwable("This method should be overridden.");
		return null;
	}

	
}
