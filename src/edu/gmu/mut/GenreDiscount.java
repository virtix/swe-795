package edu.gmu.mut;

import java.math.BigDecimal;
import java.util.Calendar;

public class GenreDiscount extends Discount {

	
	/**
	 * Gets the genre discount.
	 *
	 * @param account the account
	 * @param today the today
	 * @param string the string
	 * @return the genre discount
	 */
	public static BigDecimal getGenreDiscount(Account account, Calendar today,	String string) {
		return new BigDecimal(.2);
	}

}
