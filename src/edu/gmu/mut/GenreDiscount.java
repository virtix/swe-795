package edu.gmu.mut;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

public class GenreDiscount extends Discount {

	
	/**
	 * Provides a 20% discount if the user has made a purchase in that genre
	 * within the last month.
	 *
	 * @param account the account
	 * @param today the today
	 * @param genre music genre;e.g., jazz, rock, blues, etc.
	 * @return the genre discount
	 */
	public static BigDecimal getGenreDiscount(Account account, Calendar today,	String genre) {
		
		BigDecimal total = new BigDecimal(0);
		BigDecimal returnValue = new BigDecimal(0);
		ArrayList purchases = account.getPurchaseHistory(); 
		for(int i = 0; i < purchases.size(); i++ ){
			Purchase purcahse = (Purchase)purchases.get(i);
			if (computeDeltaDays(today, purcahse.purchaseDate) <= 30 )total = purcahse.price.add(total);
		}
		
		if(total.floatValue() > 0){
			returnValue = new BigDecimal(.2);	
		}
		else {
			returnValue = new BigDecimal(0);
		}
	  return returnValue;	
	}

}
