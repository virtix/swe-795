package edu.gmu.mut.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import edu.gmu.mut.Account;
import edu.gmu.mut.LoyaltyDiscount;
import edu.gmu.mut.Purchase;

@RunWith(Parameterized.class)
public class MutationGeneratedParameterizedTestsForLoyaltyTest extends BaseTest {

	
	/*
	 * mutation - driven parameterized unit tests
	 */
	
	Account account = AccountFixture.getNewAccount();
		
	static Calendar MARCH_5 = new GregorianCalendar(2011, Calendar.MARCH, 5);
	static String genre = "Reggae";
	

	
	//Test data that will be initialized at test time
	Purchase purchase = null;
	String expectedDiscount = null;
	
	public MutationGeneratedParameterizedTestsForLoyaltyTest(Purchase purchase, String expectedDiscount){
		this.purchase = purchase;
		this.expectedDiscount = expectedDiscount;
	}
	
	
	
	@Parameters
	public static Collection<Object[]> getPurchaseData(){
		return  Arrays.asList(  new Object[][]  {
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
			
	   });
		
	}
	 
	
	@Test
	public void testLoyaltyDiscount(){
	  account.getPurchaseHistory().add(this.purchase);
	  BigDecimal amt = LoyaltyDiscount.getDiscount(account, today);
	  String result = perFmt.format(amt.doubleValue());
	  assertEquals(this.expectedDiscount, result);
	}
	
	
	
	
}
