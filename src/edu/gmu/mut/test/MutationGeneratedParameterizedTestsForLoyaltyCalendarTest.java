package edu.gmu.mut.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.text.NumberFormat;
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
import edu.gmu.mut.GenreDiscount;
import edu.gmu.mut.LoyaltyDiscount;
import edu.gmu.mut.Purchase;

/**
 * The Class MutationGeneratedParameterizedTestsForLoyaltyCalendarTest.
 */
@RunWith(Parameterized.class)
public class MutationGeneratedParameterizedTestsForLoyaltyCalendarTest extends BaseTest {
	
	/**
	 * Test purchase history discount.
	 */
	@Test
	public void testPurchaseHistoryDiscount(){
		account.getPurchaseHistory().add(new Purchase("Reggae", this.purchaseAmt, this.purchaseDate));
		BigDecimal amt = LoyaltyDiscount.getDiscount(account, today);
		logger.info(account.toString());
		String actual = perFmt.format(amt.doubleValue());
		assertEquals(this.expectedDiscount, actual);
	}



static String genre = "Reggae";
//    Parameters initialized by JUnit runner	
	Calendar today;
	Calendar regDate;
	Calendar visitDate;
	Calendar purchaseDate;
	BigDecimal purchaseAmt;
	Account account;
	String expectedDiscount;
	ArrayList purchases;
	
	
	/**
	 * Instantiates a new mutation generated parameterized tests for loyalty calendar test.
	 *
	 * @param today the today
	 * @param regDate the reg date
	 * @param visitDate the visit date
	 * @param purchaseDate the purchase date
	 * @param purchaseAmt the purchase amt
	 * @param expectedDiscount the expected discount
	 */
	public MutationGeneratedParameterizedTestsForLoyaltyCalendarTest(Calendar today, 
																	 Calendar regDate,
																	 Calendar visitDate,
																	 Calendar purchaseDate,
																	 BigDecimal purchaseAmt,
																	 String expectedDiscount  ){
		
		this.today=today;
		this.regDate=regDate;
		this.visitDate=visitDate;
		this.purchaseDate=purchaseDate;
		this.purchaseAmt=purchaseAmt;
		this.purchases=new ArrayList();
		this.account = Account.newInstance("bill", "bill@if.io", regDate, visitDate, this.purchases );
		this.expectedDiscount = expectedDiscount;
	}

	
	
	static Calendar MARCH_1  = new GregorianCalendar(2011,Calendar.MARCH, 1);
	static Calendar MARCH_5  = new GregorianCalendar(2011,Calendar.MARCH, 5);
	static Calendar MARCH_6  = new GregorianCalendar(2011,Calendar.MARCH, 6);
	static Calendar MARCH_20  = new GregorianCalendar(2011,Calendar.MARCH, 20);
	static Calendar MARCH_30  = new GregorianCalendar(2011,Calendar.MARCH, 30);
	static Calendar MARCH_31  = new GregorianCalendar(2011,Calendar.MARCH, 31);
	static Calendar APRIL_1  = new GregorianCalendar(2011,Calendar.APRIL, 1);
	static Calendar APRIL_2  = new GregorianCalendar(2011,Calendar.APRIL, 2);
	static Calendar APRIL_6  = new GregorianCalendar(2011,Calendar.APRIL, 6);
	static Calendar MARCH_5_2010  = new GregorianCalendar(2010,Calendar.MARCH, 5);
	static BigDecimal bd1 = new BigDecimal(99.87);
	static BigDecimal bd2 = new BigDecimal(100.99);
	static BigDecimal bd3 = new BigDecimal(24.99);
	static BigDecimal bd4 = new BigDecimal(25.99);
	static BigDecimal bd5 = new BigDecimal(59.99);
	static BigDecimal bd6 = new BigDecimal(0.99);
	static BigDecimal bd7 = new BigDecimal(50.00);
	static BigDecimal bd8 = new BigDecimal(100.00);
	static BigDecimal bd9 = new BigDecimal(25.00);
	static BigDecimal bd10 = new BigDecimal(-2.00);
	static BigDecimal bd11 = new BigDecimal(0.00);
	
		
	
		
	/**
	 * Gets account data used to drive the test.
	 *
	 * @return the account data
	 */
	@Parameters
	public static Collection<Object[]> getAccountData(){
		return  Arrays.asList(  new Object[][]  {
				//today,   regDate,  visitDate, purchaseDate, purchaseAmt,  expected discount
				{APRIL_6,  MARCH_1,  MARCH_20,  MARCH_5,      bd10,         "5%" },    //??
				{APRIL_6,  MARCH_1,  MARCH_20,  MARCH_5,      bd5,          "10%" },   //test 14 
				{APRIL_6,  MARCH_31, MARCH_20,  MARCH_5_2010, bd5,          "15%" },    //should be exception
				{APRIL_6,  MARCH_31, MARCH_20,  MARCH_5_2010, bd5,          "15%" },    //should be exception
				{APRIL_6,  MARCH_1,  MARCH_20,  MARCH_5_2010, bd5,          "50%" },    //should be exception
				{APRIL_6,  MARCH_31, MARCH_20,  MARCH_5_2010, bd5,          "15%" },    //test 15 COR_7
				{APRIL_6,  MARCH_6,  MARCH_20,  MARCH_5_2010, bd5,          "15%" },    //test 17 ROR_13
				{APRIL_6,  MARCH_1,  MARCH_20,  MARCH_5_2010, bd10,         "5%"  },    //test 17 ROR_13
				{APRIL_6,  MARCH_1,  APRIL_2,   MARCH_5,      bd10,         "5%"  },    //test 21 ROR_34
				{APRIL_6,  MARCH_1,  MARCH_30,  MARCH_5,      bd11,         "10%"  },    //test 22 ROR_38
				{APRIL_6,  MARCH_6,  APRIL_2,   MARCH_5,      bd10,         "5%"  },    //test 22 ROR_38
		});
	}	
}