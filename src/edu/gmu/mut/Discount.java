package edu.gmu.mut;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import org.mockito.internal.stubbing.answers.ThrowsException;

// TODO: Auto-generated Javadoc
/**
 * The Interface Discount.
 */
public class Discount {

	/**
	 * Gets the discount.
	 *
	 * @param account the account
	 * @param startDate the start date
	 * @return the discount
	 */
	public static BigDecimal getDiscount(Account account, Calendar startDate) {
		throw new RuntimeException();
	}

	/**
	 * Computes the total amount of purchases of this account.
	 *
	 * @param account the account
	 * @return the total purchases
	 */
	public static BigDecimal getTotalPurchases(Account account) {
		BigDecimal total = new BigDecimal(0);
		ArrayList purchases = account.getPurchaseHistory();
		for(int i = 0; i < purchases.size(); i++){
			Purchase p = (Purchase)purchases.get(i);
			total = p.price.add(total);
		}
		return total;
	}

	/**
	 * Computes the difference in DAYS between two dates (GregorianCalendar).
	 *
	 * @param today the today
	 * @param targetDate the target date
	 * @return the long
	 */
	public static long computeDeltaDays(Calendar today, Calendar targetDate) {
		long today_ms = today.getTimeInMillis();
		long reg_ms = targetDate.getTimeInMillis();
		long diff_days = (today_ms-reg_ms) / (24 * 60 * 60 * 1000);
		return diff_days;
	}

	
}
