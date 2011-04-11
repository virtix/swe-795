package edu.gmu.mut.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import edu.gmu.mut.Account;
import edu.gmu.mut.LoyaltyDiscount;
import edu.gmu.mut.Purchase;

@RunWith(Theories.class)
public class MutationTheory extends BaseTest {

	
	/*
	 * mutation - driven parameterized unit tests
	 */
	
	Account account = AccountFixture.getNewAccount();
		
	static Calendar marchDate = new GregorianCalendar(2011, Calendar.MARCH, 5);
	static String genre = "Reggae";
	
	//Purchase + expected discount
	@DataPoints
	public static Object[][]  purchaseData = {
			{new Purchase(genre, new BigDecimal(99.87), marchDate),"10%"},
			{new Purchase(genre, new BigDecimal(100.99), marchDate),"20%"},
			{new Purchase(genre, new BigDecimal(24.99), marchDate),"50%"},
			{new Purchase(genre, new BigDecimal(25.99), marchDate),"10%"},
			{new Purchase(genre, new BigDecimal(49.99), marchDate),"10%"},
			{new Purchase(genre, new BigDecimal(50.00), marchDate),"10%"},
			{new Purchase(genre, new BigDecimal(0.99), marchDate),"50%"},
			{new Purchase(genre, new BigDecimal(50.00), marchDate),"10%"},
			{new Purchase(genre, new BigDecimal(100.00), marchDate),"20%"},
			{new Purchase(genre, new BigDecimal(25.00), marchDate),"10%"},
			
	};
	
	@Theory
	public void testLoyaltyDiscount(Object[] purchaseTestData){
//	  SetUp
	  String expectedDiscount = (String) purchaseTestData[1];
	  Purchase purchase = (Purchase)purchaseTestData[0];
	  account.getPurchaseHistory().add(purchase);
//      Exercise
	  BigDecimal amt = LoyaltyDiscount.getDiscount(account, today);
	  String result = perFmt.format(amt.doubleValue());
//	  Test
	  assertEquals(expectedDiscount, result);
	}
	
	
	

	
	
	
	/*
	 * all following tests can be generalized into one PUT with different test data
	 * the statements that contain parameters are marked with '**'
	 * @Test
	 * public void test(BigDecimal valueOfPurchase, GregorianCalendar regDate, GregorianCalendar visitDate, GregorianCalendar purchaseDate){
	 * 	Calendar today = new GregorianCalendar( 2011, Calendar.APRIL, 6 );
	 * 	ArrayList purchases = new ArrayList();
	 **     Account account = Account.newInstance("new bill", "new_bill@if.io", regDate, visitDate, purchases );
	 ** 	account.getPurchaseHistory().add(new Purchase("Reggae", bd1, purchaseDate));
	 * 	BigDecimal amt = LoyaltyDiscount.getDiscount(account, today);
	 *  String result = perFmt.format(amt.doubleValue());
	 *	assertEquals(someValue, result);
	 * }
	 */		
	
	
//	//parameters for the following tests
	BigDecimal bd1 = new BigDecimal(99.87);
	BigDecimal bd2 = new BigDecimal(100.99);
	BigDecimal bd3 = new BigDecimal(24.99);
	BigDecimal bd4 = new BigDecimal(25.99);
	BigDecimal bd5 = new BigDecimal(49.99);
	BigDecimal bd6 = new BigDecimal(0.99);
	BigDecimal bd7 = new BigDecimal(50.00);
	BigDecimal bd8 = new BigDecimal(100.00);
	BigDecimal bd9 = new BigDecimal(25.00);

	
	Calendar today1 = new GregorianCalendar(2011, Calendar.APRIL, 6);
	Calendar regDate1  = new GregorianCalendar(2011,Calendar.MARCH, 1);
	Calendar regDate2 = new GregorianCalendar(2011,Calendar.MARCH, 31);
	Calendar regDate3 = new GregorianCalendar(2011,Calendar.MARCH, 6);
	Calendar visitDate1 = new GregorianCalendar(2011,Calendar.MARCH, 20);
	Calendar visitDate2 = new GregorianCalendar(2011,Calendar.APRIL,2);
	Calendar visitDate3 = new GregorianCalendar(2011,Calendar.MARCH,30);
	GregorianCalendar purchaseDate1 = new GregorianCalendar(2010, Calendar.MARCH, 5);
	GregorianCalendar purchaseDate2 = new GregorianCalendar(2011, Calendar.MARCH, 5);
	ArrayList purchases = new ArrayList();
	BigDecimal bd10 = new BigDecimal(-2.00);
	BigDecimal bd11 = new BigDecimal(0.00);
		public void test14(){	
			Account account = Account.newInstance("new bill", "new_bill@if.io", regDate1, visitDate1, purchases );
			account.getPurchaseHistory().add(new Purchase("Reggae", bd5, purchaseDate1));	
			BigDecimal amt = LoyaltyDiscount.getDiscount(account, today1);
			String result = perFmt.format(amt.doubleValue());
			assertEquals("50%", result);
		}//end of the test 14
		//should kill COR_7, but muJava did not
		public void test15(){		
			ArrayList purchases = new ArrayList();
			Account account = Account.newInstance("new bill", "new_bill@if.io", regDate2, visitDate1, purchases );
			account.getPurchaseHistory().add(new Purchase("Reggae", bd5, purchaseDate1));	
			BigDecimal amt = LoyaltyDiscount.getDiscount(account, today1);
			String result = perFmt.format(amt.doubleValue());
			assertEquals("15%", result);
		}//end of the test 15
		
		//designed for ROR_13
		public void test17(){	
			Account account = Account.newInstance("new bill", "new_bill@if.io", regDate3, visitDate1, purchases);
			account.getPurchaseHistory().add(new Purchase("Reggae", bd5, purchaseDate1));	
			BigDecimal amt = LoyaltyDiscount.getDiscount(account, today1);
			String result = perFmt.format(amt.doubleValue());
			assertEquals("15%", result);
		}//end of the test 17


		//designed for ROR_30
		//supposed to render an error message
		//this probably is the important test
		public void test20(){
			Account account = Account.newInstance("new bill", "new_bill@if.io", regDate1, visitDate1, purchases );
			account.getPurchaseHistory().add(new Purchase("Reggae", bd10, purchaseDate1));	
			BigDecimal amt = LoyaltyDiscount.getDiscount(account, today1);
			String result = perFmt.format(amt.doubleValue());
			assertEquals("5%", result);
		}//end of the test 20
		//designed for ROR_34
		public void test21(){
			Account account = Account.newInstance("new bill", "new_bill@if.io", regDate1, visitDate2, purchases );
			account.getPurchaseHistory().add(new Purchase("Reggae", bd10, purchaseDate2));	
			BigDecimal amt = LoyaltyDiscount.getDiscount(account, today1);
			String result = perFmt.format(amt.doubleValue());
			assertEquals("5%", result);
		}//end of the test 21
		//designed for ROR_38
		public void test22(){
			Account account = Account.newInstance("new bill", "new_bill@if.io", regDate1, visitDate3, purchases );
			account.getPurchaseHistory().add(new Purchase("Reggae", bd11, purchaseDate2));	
			BigDecimal amt = LoyaltyDiscount.getDiscount(account, today1);
			String result = perFmt.format(amt.doubleValue());
			assertEquals("10%", result);
		}//end of the test 22
	//designed for ROR_9
	public void test26(){
		Account account = Account.newInstance("new bill", "new_bill@if.io", regDate3, visitDate2, purchases );
		account.getPurchaseHistory().add(new Purchase("Reggae", bd10, purchaseDate2));	
		BigDecimal amt = LoyaltyDiscount.getDiscount(account, today1);
		String result = perFmt.format(amt.doubleValue());
		assertEquals("5%", result);
	}//end of the test 26
	
	/*
	 * all following tests can be generalized into one PUT with different test data
	 * the statements that contain parameters are marked with '**'
	 * @Test
	 * public void test(GregorianCalendar today, int days){
	 * 	Account account = AccountFixture.getBasicAccount();
	 **     BigDecimal amt = LoyaltyDiscount.getTotalPurchasesBetweenNowAndNDays(account, today, 365);
	 *  String result = perFmt.format(amt.doubleValue());
	 *	assertEquals(someValue, result);
	 * }
	 */	
	Calendar today2 = new GregorianCalendar( 2011, Calendar.APRIL, 1 );
	Calendar today3 = new GregorianCalendar( 2011, Calendar.APRIL, 5 );
	int days1 = 365;
	int days2 = 30;
	int days3 = 29;
		public void test23(){
			Account account = AccountFixture.getBasicAccount();
			BigDecimal amt = LoyaltyDiscount.getTotalPurchasesBetweenNowAndNDays(account, today2, days1);
			String result = curFmt.format(amt.doubleValue());
			assertEquals("$60.88", result);
		}//end of the test 23
		public void test24(){
			Account account = AccountFixture.getBasicAccount();
			BigDecimal amt = LoyaltyDiscount.getTotalPurchasesBetweenNowAndNDays(account, today3, days2);
			String result = curFmt.format(amt.doubleValue());
			assertEquals("$2.98", result);
		}//end of the test 24
		public void test25(){
			Calendar today = new GregorianCalendar( 2011, Calendar.APRIL, 5 );
			Account account = AccountFixture.getBasicAccount();
			BigDecimal amt = LoyaltyDiscount.getTotalPurchasesBetweenNowAndNDays(account, today3, days3);
			String result = curFmt.format(amt.doubleValue());
			assertEquals("$0.00", result);
		}//end of the test 25

	
	
}
