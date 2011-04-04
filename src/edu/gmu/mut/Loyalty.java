package edu.gmu.mut;

import java.math.BigDecimal;

public final class Loyalty {

	public static BigDecimal getTotalPurchases(Account account) {
		BigDecimal total = new BigDecimal(0);
		for(Purchase p : account.getPurchaseHistory()){
			total = p.price.add(total);
		}
		return total;
	}

	
	
	//TO DO: Still need to add date constraints!
	public static BigDecimal getDiscountAmount(Account account) {
		
		BigDecimal discount = new BigDecimal(0);
		
		double total = getTotalPurchases(account).doubleValue(); 
	
		if(  total >= 50 && total < 100  ){
			discount = new BigDecimal(0.10);
		}
		else if(total == 0){ //DATE?
			discount = new BigDecimal(0.15);
		}
		else if (total >= 100){ //DATE? 
			discount = new BigDecimal(0.20);
		}
		else if (total >= 25 && total < 50){ //DATE? 
			discount = new BigDecimal(0.05);
		}
		
		
		
		return discount;
	}

	
	
	

} //end class
