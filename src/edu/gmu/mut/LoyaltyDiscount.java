package edu.gmu.mut;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * Class Loyalty represents a set of business rules, providing static methods to compute 
 * a <i>possible</i> discount for a given account. The discounts are based on attributes 
 * such as purchase history and site activity.
 * 
 */
public final class LoyaltyDiscount extends Discount {

	
	
	
	/**
	 * Given a start date, computes a possible discount.
	 *
	 * @param account the account
	 * @param startDate the start date
	 * @return the discount amount
	 */
	public static BigDecimal getDiscount(Account account, Calendar startDate) {
		
		BigDecimal discount = new BigDecimal(0);
		Calendar regDate = account.getDateRegistered();
		
//		double monthlyTotal = getTotalPurchasesBetweenNowAndNDays(account, startDate,30).doubleValue();
		double annualTotal = getTotalPurchasesBetweenNowAndNDays(account, startDate,365).doubleValue();
		double twoYearTotal = getTotalPurchasesBetweenNowAndNDays(account, startDate,365*2).doubleValue();
		//one year rule
		double total = getTotalPurchasesBetweenNowAndNDays(account, startDate,365).doubleValue();
		
		if(  annualTotal >= 50 && annualTotal < 100 ){
			discount = new BigDecimal(0.10);
		}
		//new user rule
		else if(total == 0 && computeDeltaDays(startDate, regDate) <= 30  ){
			discount = new BigDecimal(0.15);
		}
		//big spender
		else if (annualTotal >= 100  ){
			discount = new BigDecimal(0.20);
		}
		//25-50 annual
		else if (annualTotal >= 25 && annualTotal < 50 ){
			discount = new BigDecimal(0.10);
		}
		//2 year rule
		else if (twoYearTotal > 0 ){
			discount = new BigDecimal(0.5);
		}
		else if (total == 0 && computeDeltaDays(startDate,account.getLastVisitDate()) <= 7 ){
			discount = new BigDecimal(0.10);
		}
		//default
		else {
			discount = new BigDecimal(0.05);
		}
		return discount;
	}



	
	/**
	 * Gets the total purchases between NOW and some number N of days.
	 *
	 * @param account the account
	 * @param today the today
	 * @param numberOfDays the number of days
	 * @return the total purchases between now and n days
	 */
	public static BigDecimal getTotalPurchasesBetweenNowAndNDays( Account account, Calendar today, int numberOfDays) {
		BigDecimal total = new BigDecimal(0);	
		ArrayList purchases = account.getPurchaseHistory(); 
		for(int i = 0; i < purchases.size(); i++ ){
			Purchase purcahse = (Purchase)purchases.get(i);
			if (computeDeltaDays(today, purcahse.purchaseDate) <= numberOfDays )total = purcahse.price.add(total);
		}
		return total;
	}

	
	
	

} //end class
