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

public class DiscountTest extends BaseTest {
	@Test(expected=Throwable.class)
	public void getDiscountInParentShouldThrowException(){
		Discount.getDiscount(AccountFixture.getBasicAccount(), today);
	}
	
	
	 @Test
	 public void test1(){
		 //refactoring, defining new type Discount
		 Account account = AccountFixture.getBasicAccount();
		BigDecimal amt = Discount.getTotalPurchases(account);
		String result = curFmt.format(amt.doubleValue());
		assertEquals( "$67.86" , result );
	 }
	 
		/*
		 * all following tests can be generalized into one PUT with different test data
		 * the statements that contain parameters are marked with '**'
		 * @Test
		 * public void test(long value, GregorianCalendar targetDate){
		 * 	Calendar today = new GregorianCalendar( 2011, Calendar.APRIL, 6 );
		 ** 	today.setTimeInMillis(value);
		 ** 	long result = Discount.computeDeltaDays(today, targetDate);
		 *	assertEquals(someValue, result);
		 * }
		 */
	 long value = 1302148799999L;
	 long value1 = 1302148800000L;
	 Calendar targetDate = new GregorianCalendar(2011,Calendar.MARCH,30);
	 Calendar targetDate1 = new GregorianCalendar(1990,Calendar.MARCH,30);
	 @Test
	 public void test2(){
			Calendar today = new GregorianCalendar( 2011, Calendar.APRIL, 6 );
			//this long value represents 2011/04/06 23:59:59:999
			today.setTimeInMillis(value);	
			long result =  Discount.computeDeltaDays(today, targetDate);
			assertEquals(7, result);
		}//end of the test 2
	 @Test
		public void test3(){
			Calendar today = new GregorianCalendar( 2011, Calendar.APRIL, 6 );
			//this long value represents 2011/04/07 00:00:00:000
			today.setTimeInMillis(value1);	
			long result =  Discount.computeDeltaDays(today, targetDate);
			assertEquals(8, result);
		}//end of the test 3
	 @Test
		public void test4(){
			Calendar today = new GregorianCalendar( 2011, Calendar.APRIL, 6 );
			//this long value represents 2011/04/07 00:00:00:000
			today.setTimeInMillis(value1);				
			long result =  Discount.computeDeltaDays(today, targetDate1);
			assertEquals(7677, result);
		}//end of the test 4

}
