package edu.gmu.mut.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import edu.gmu.mut.Purchase;


public class PurchaseTest extends BaseTest {

	@Test
	public void createArbitraryPurchases() {
		GregorianCalendar now = new GregorianCalendar();
		ArrayList<Purchase> purchases = new ArrayList<Purchase>();
		
		for (int i = 0 ; i < 10; i++){
			now = new GregorianCalendar(); 
			purchases.add(new Purchase("Jazz", 0.99, now) );
			purchases.add(new Purchase("Rock", 9.99, now) );
			purchases.add(new Purchase("Punk", 4.99, now) );
			logger.info( purchases.get(i).toString() );
		}
		
		assertEquals(30,purchases.size());
	}
	

	
	@Test
	public void purchaseShouldAddAndReturnCorrectString(){
		Purchase p = new Purchase( "MUSIC", .99, new GregorianCalendar(2011,Calendar.APRIL,1) );
		logger.info( p.toString() );
		assertEquals( "MUSIC,0.99,4/1/11 12:00 AM" , p.toString() );
	}
	
}
