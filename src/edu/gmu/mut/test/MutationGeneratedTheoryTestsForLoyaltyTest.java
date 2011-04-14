package edu.gmu.mut.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import edu.gmu.mut.Account;
import edu.gmu.mut.LoyaltyDiscount;
import edu.gmu.mut.Purchase;

@RunWith(Theories.class)
public class MutationGeneratedTheoryTestsForLoyaltyTest extends BaseTest {

	/*
	 * mutation - driven parameterized unit tests
	 */
	
	Account account = AccountFixture.getNewAccount();
		
	static Calendar MARCH_5 = new GregorianCalendar(2011, Calendar.MARCH, 5);
	static Calendar MARCH_5_2010 = new GregorianCalendar(2010, Calendar.MARCH, 5);
	
	static String genre = "Reggae";
	
//	@DataPoints
	public static Object[] getPurchaseData(){
		return  new Object[][]  {
			{new Purchase(genre, new BigDecimal(99.87), MARCH_5),  "10%"},
			{new Purchase(genre, new BigDecimal(100.99), MARCH_5), "20%"},
			{new Purchase(genre, new BigDecimal(24.99), MARCH_5),  "50%"},
			{new Purchase(genre, new BigDecimal(25.99), MARCH_5),  "10%"},
			{new Purchase(genre, new BigDecimal(49.99), MARCH_5),  "10%"},
			{new Purchase(genre, new BigDecimal(50.00), MARCH_5),  "10%"},
			{new Purchase(genre, new BigDecimal(0.99), MARCH_5),   "50%"},
			{new Purchase(genre, new BigDecimal(50.00), MARCH_5),  "10%"},
			{new Purchase(genre, new BigDecimal(100.00), MARCH_5), "20%"},
			{new Purchase(genre, new BigDecimal(25.00), MARCH_5),  "10%"}
			
	   };
		
	}
	 
	
	
	
	@DataPoint
	public static BigDecimal bd1 = new BigDecimal(1.00);
	
	@DataPoint
	public static BigDecimal negBD = new BigDecimal(-1.00);
	
	@DataPoint
	public static BigDecimal zeroBD = new BigDecimal(0.00);
	
	
	
	
	@DataPoint
	public static Calendar APRIL_1 = new GregorianCalendar(2011, Calendar.APRIL, 1);
	
	@DataPoint
	public static Calendar APRIL_1_2010 = new GregorianCalendar(2010, Calendar.APRIL, 1);
	
	@DataPoint
	public static Calendar APRIL_1_2020 = new GregorianCalendar(2020, Calendar.APRIL, 1);
	
	
//	, Calendar cal
	@Theory
	public void testLoyaltyDiscount(BigDecimal bd, Calendar cal){
		
		logger.info( curFmt.format(bd) );
		logger.info( cal.getTime().toString() );
		
		Purchase purchase = new Purchase(genre, bd, cal);
		
//       Purchase purchase = (Purchase) purchases[0];
//       String expectedDiscount = (String) purchases[1];
//       logger.info(purchase.toString());
//	   account.getPurchaseHistory().add(purchase);
//	   BigDecimal amt = LoyaltyDiscount.getDiscount(account, today);
//	   String result = perFmt.format(amt.doubleValue());
//	   assertEquals(expectedDiscount, result);
	}
	
	
	
	
} //
