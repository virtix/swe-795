package edu.gmu.mut;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;


public class PurchaseTest extends BaseTest {

	@Test
	public void createPurchases() {
		GregorianCalendar now = new GregorianCalendar();
		ArrayList<Purchase> purchases = new ArrayList<Purchase>();
		
		for (int i = 0 ; i < 10; i++){
			now = new GregorianCalendar(); 
			purchases.add(new Purchase("MUSIC", 0.99, now) );
			purchases.add(new Purchase("VIDEO", 9.99, now) );
			purchases.add(new Purchase("FOOD", 5, now) );
			logger.info( purchases.get(i).toString() );
		}
		
		assertEquals(10,purchases.size());
	}
	

	
	@Test
	public void purchaseShouldReturnCorrectString(){
		Purchase p = new Purchase( "MUSIC", .99, new GregorianCalendar(2011,Calendar.APRIL,1) );
		logger.info( p.toString() );
		assertEquals( "MUSIC,0.99,4/1/11 12:00 AM" , p.toString() );
	}
	
}
