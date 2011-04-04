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

	
	
	// TO DO: Still need to add date constraints!
	// Compute the total amount spent in given constraint
	public static BigDecimal getDiscountAmount(Account account, Calendar startDate) {
		
		BigDecimal discount = new BigDecimal(0);
		
		double total = getTotalPurchases(account).doubleValue(); 
	
		if(  total >= 50 && total < 100 ){
			discount = new BigDecimal(0.10);
		}
		else if(total == 0 ){ //DATE? New Users?
			discount = new BigDecimal(0.15);
		}
		else if (total >= 100 ){ //DATE? 
			discount = new BigDecimal(0.20);
		}
		else if (total >= 25 && total < 50 ){ //DATE? 
			discount = new BigDecimal(0.10);
		}
		else {
			discount = new BigDecimal(0.05);
		}
		
		
		
		return discount;
	}



	public static long computeDeltaDays(Calendar today, Calendar regDate) {
		long today_ms = today.getTimeInMillis();
		long reg_ms = regDate.getTimeInMillis();
		long diff_days = (today_ms-reg_ms) / (24 * 60 * 60 * 1000);
		return diff_days;
	}

	
	
	

} //end class
