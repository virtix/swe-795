package edu.gmu.mut.test;

import static org.junit.Assert.*;

import org.junit.Test;
import edu.gmu.mut.Account;
import edu.gmu.mut.Loyalty;
import edu.gmu.mut.Purchase;

import java.math.BigDecimal;
import java.text.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class LoyaltyTest extends BaseTest {

	NumberFormat curFmt = NumberFormat.getCurrencyInstance();
	NumberFormat perFmt = NumberFormat.getPercentInstance();
	
	@Test
	public void calcDayDelta(){
		Calendar regDate = new GregorianCalendar( 2010, Calendar.MAY, 5 );
		Calendar   today = new GregorianCalendar( 2011, Calendar.APRIL, 4 );
		long actualDiff = Loyalty.computeDeltaDays( today, regDate );
		//-----------------------------
		assertEquals( 334, actualDiff );
	}

	
	@Test
	public void dateCompareTestSpike(){
		GregorianCalendar cal1 = new GregorianCalendar(2010,1,1);
		GregorianCalendar cal2 = new GregorianCalendar();
    	  assertTrue( cal1.before(cal2) );
	}
	
	
	@Test
	public void usersWhoHaveSpent25To50InLastYearGet5Percent(){
		Purchase p =  new Purchase("Coltrane", new BigDecimal(29.99), new GregorianCalendar() );
		Calendar today  = new GregorianCalendar( 2011, Calendar.APRIL, 3 );
		
		ArrayList<Purchase> purchases = new ArrayList<Purchase>();
		purchases.add(p);
		Account account = Account.newInstance( "ed", "ed@ed.com", new GregorianCalendar(2009,2,1),new GregorianCalendar(), purchases );
		BigDecimal amt = Loyalty.getDiscountAmount(account, today);
		String result = perFmt.format(amt.doubleValue());
		assertEquals( "10%" , result  );
	}
	
	@Test
	public void usersWhoHaveSpent100OorMoreInLastYearGet20Percent(){
		Purchase p =  new Purchase("Coltrane", new BigDecimal(199.99), new GregorianCalendar() );
		ArrayList<Purchase> purchases = new ArrayList<Purchase>();
		purchases.add(p);
		Account account = Account.newInstance( "ed", "ed@ed.com", new GregorianCalendar(2009,2,1),new GregorianCalendar(), purchases );
		BigDecimal amt = Loyalty.getDiscountAmount(account, new GregorianCalendar(2011, Calendar.APRIL,3));
		String result = perFmt.format(amt.doubleValue());
		assertEquals( "20%" , result  );
	}
	
	@Test
	public void newUsersWhoHaveNotMadePurchasesShouldGet15Percent(){
		Account account = Account.newInstance( "ed", "ed@ed.com", new GregorianCalendar(),new GregorianCalendar(), new ArrayList<Purchase>() );
		BigDecimal amt = Loyalty.getDiscountAmount(account, new GregorianCalendar());
		String result = perFmt.format(amt.doubleValue());
		assertEquals( "15%" , result  );
	}
	
	@Test
	public void discountForBasicUserShouldBe10Percent(){
		Account account = AccountFixture.getBasicAccount();
		BigDecimal amt = Loyalty.getDiscountAmount(account, new GregorianCalendar());
		String result = perFmt.format(amt.doubleValue());
		logger.info(result);
		assertEquals( "10%" , result  );
	}
	
	
	@Test
	public void testSimpleCreateLoyaltyDiscount(){
		Account account = AccountFixture.getBasicAccount();
		BigDecimal amt = Loyalty.getTotalPurchases(account);
		String result = curFmt.format(amt.doubleValue()) ; 
		assertEquals( "$64.88" , result  );
	}

	@Test
	public void bigDecimalSpike(){
		BigDecimal amt1 = new BigDecimal(0.99);
		BigDecimal amt2 = new BigDecimal(0.01);
		BigDecimal tot = amt1.add(amt2);
		String result = curFmt.format(tot.doubleValue());
	    logger.info( result );
	    assertEquals( "$1.00" , result );
	}
	

}
