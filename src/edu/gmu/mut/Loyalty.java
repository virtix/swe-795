package edu.gmu.mut;

import java.math.BigDecimal;
import java.util.Calendar;

public final class Loyalty {

	
	
	
	public static BigDecimal getTotalPurchases(Account account) {
		BigDecimal total = new BigDecimal(0);
		for(Purchase p : account.getPurchaseHistory()){
			total = p.price.add(total);
		}
		return total;
	}

	
	
	public static BigDecimal getDiscountAmount(Account account, Calendar startDate) {
		
		BigDecimal discount = new BigDecimal(0);
		Calendar regDate = account.getDateRegistered();
		
//		double monthlyTotal = getTotalPurchasesBetweenNowAndNDays(account, startDate,30).doubleValue();
		double annualTotal = getTotalPurchasesBetweenNowAndNDays(account, startDate,365).doubleValue();
		double twoYearTotal = getTotalPurchasesBetweenNowAndNDays(account, startDate,365*2).doubleValue();
		double total = getTotalPurchases(account).doubleValue(); 
	
		//one year rule
		total = getTotalPurchasesBetweenNowAndNDays(account, startDate,365).doubleValue();
		
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



	
	public static long computeDeltaDays(Calendar today, Calendar targetDate) {
		long today_ms = today.getTimeInMillis();
		long reg_ms = targetDate.getTimeInMillis();
		long diff_days = (today_ms-reg_ms) / (24 * 60 * 60 * 1000);
		return diff_days;
	}


	

	public static BigDecimal getTotalPurchasesBetweenNowAndNDays( Account account, Calendar today, int numberOfDays) {
		BigDecimal total = new BigDecimal(0);	
		for(Purchase p : account.getPurchaseHistory()){
			 if (computeDeltaDays(today, p.purchaseDate) <= numberOfDays )total = p.price.add(total);
		}
		return total;
	}

	
	
	

} //end class
