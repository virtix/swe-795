package edu.gmu.mut.test;

import static org.junit.Assert.*;

import org.junit.Test;
import edu.gmu.mut.Account;
import edu.gmu.mut.Discount;
import edu.gmu.mut.GenreDiscount;
import edu.gmu.mut.LoyaltyDiscount;
import edu.gmu.mut.Purchase;

import java.math.BigDecimal;
import java.text.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class GenreDiscountTest extends BaseTest {

	@Test
	public void reggaeGets20PercentIfPurchasedInLastMonth(){
		Account account = AccountFixture.getBasicAccount(); //purchased reggae in last
		BigDecimal actual = GenreDiscount.getGenreDiscount(account, today, "Reggae");
		assertEquals( "20%" , perFmt.format(actual.doubleValue()) );
	}
	
	
	@Test
	public void genreDiscountIsOfCorrectType(){
		Discount discount = new GenreDiscount();
		assertEquals( "edu.gmu.mut.GenreDiscount", discount.getClass().getCanonicalName() );
	}
	
	/*
	 * mutation - driven tests
	 * all following tests can be generalized into one PUT with different test data
	 * the statements that contain parameters are marked with '**'
	 * @Test
	 * public void test(BigDecimal bd1, BigDecimal bd2, GregorianCalendar gc1){
	 * 	Calendar regDate = new GregorianCalendar(2011,Calendar.MARCH,6);
	 * 	Calendar visitDate = new GregorianCalendar(2011,Calendar.APRIL,2);
	 * 	ArrayList purchases = new ArrayList();
	 * 	Account account = Account.newInstance("new bill", "new_bill@if.io", regDate, visitDate, purchases );
	 ** 	account.getPurchaseHistory().add(new Purchase("Reggae", bd1, gc1));	
	 ** 	account.getPurchaseHistory().add(new Purchase("Reggae", bd2, new GregorianCalendar(2011, Calendar.MARCH, 5)));
	 * 	Calendar today = new GregorianCalendar( 2011, Calendar.APRIL, 1 );
	 *  String result = perFmt.format(GenreDiscount.getGenreDiscount(account, today, "Classic").doubleValue());
	 *	assertEquals(someValue, result);
	 * }
	 */
	
	//parameters for the following tests
	BigDecimal bd1 = new BigDecimal(2.00);
	BigDecimal bd2 = new BigDecimal(-2.00);
	BigDecimal bd3 = new BigDecimal(22.00);
	BigDecimal bd4 = new BigDecimal(-22.00);
	GregorianCalendar gc = new GregorianCalendar(2011, Calendar.MARCH, 5);
	
	@Test
	public void test3(){
		Calendar regDate = new GregorianCalendar(2011,Calendar.MARCH,6);
		Calendar visitDate = new GregorianCalendar(2011,Calendar.APRIL,2);
		ArrayList purchases = new ArrayList();
		Account account = Account.newInstance("new bill", "new_bill@if.io", regDate, visitDate, purchases );
		account.getPurchaseHistory().add(new Purchase("Reggae", bd1, gc));	
		account.getPurchaseHistory().add(new Purchase("Reggae", bd2, gc));	
		Calendar today = new GregorianCalendar( 2011, Calendar.APRIL, 1 );
		String result = perFmt.format(GenreDiscount.getGenreDiscount(account, today, "Classic").doubleValue());
		assertEquals("0%", result);
	} 
	
	@Test
	public void test4(){
		Calendar regDate = new GregorianCalendar(2011,Calendar.MARCH,6);
		Calendar visitDate = new GregorianCalendar(2011,Calendar.APRIL,2);
		ArrayList purchases = new ArrayList();
		Account account = Account.newInstance("new bill", "new_bill@if.io", regDate, visitDate, purchases );
		account.getPurchaseHistory().add(new Purchase("Reggae", bd3, gc));	
		account.getPurchaseHistory().add(new Purchase("Reggae", bd2, gc));	
		Calendar today = new GregorianCalendar( 2011, Calendar.APRIL, 1 );
		String result = perFmt.format(GenreDiscount.getGenreDiscount(account, today, "Classic").doubleValue());
		assertEquals("20%", result);
	} 
	
	@Test
	public void test5(){
		Calendar regDate = new GregorianCalendar(2011,Calendar.MARCH,6);
		Calendar visitDate = new GregorianCalendar(2011,Calendar.APRIL,2);
		ArrayList purchases = new ArrayList();
		Account account = Account.newInstance("new bill", "new_bill@if.io", regDate, visitDate, purchases );
		account.getPurchaseHistory().add(new Purchase("Reggae", bd3, new GregorianCalendar(2011, Calendar.MARCH, 1)));	
		account.getPurchaseHistory().add(new Purchase("Reggae", bd2, gc));	
		Calendar today = new GregorianCalendar( 2011, Calendar.APRIL, 1 );
		String result = perFmt.format(GenreDiscount.getGenreDiscount(account, today, "Classic").doubleValue());
		assertEquals("20%", result);
	} 
	
	@Test
	public void test6(){
		Calendar regDate = new GregorianCalendar(2011,Calendar.MARCH,6);
		Calendar visitDate = new GregorianCalendar(2011,Calendar.APRIL,2);
		ArrayList purchases = new ArrayList();
		Account account = Account.newInstance("new bill", "new_bill@if.io", regDate, visitDate, purchases );
		account.getPurchaseHistory().add(new Purchase("Reggae", bd4, gc));	
		account.getPurchaseHistory().add(new Purchase("Reggae", bd1, gc));	
		Calendar today = new GregorianCalendar( 2011, Calendar.APRIL, 1 );
		String result = perFmt.format(GenreDiscount.getGenreDiscount(account, today, "Classic").doubleValue());
		assertEquals("0%", result);
	} 
	

}
