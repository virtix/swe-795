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
	Calendar today = new GregorianCalendar( 2011, Calendar.APRIL, 1 );
	

	@Test
	public void onTheFenceUsersShouldGet10PercentOff(){
		Calendar today  = new GregorianCalendar( 2011, Calendar.APRIL, 3 );
		ArrayList<Purchase> purchases = new ArrayList<Purchase>();
		Account account = Account.newInstance( "ed", "ed@ed.com", new GregorianCalendar(2009,Calendar.FEBRUARY,14),today, purchases );
		BigDecimal amt = Loyalty.getDiscountAmount(account, today);
		String result = perFmt.format(amt.doubleValue());
		assertEquals( "10%" , result  );
	}
	
	@Test
	public void usersWhoHaveSpent25To50InLastYearGet10Percent(){
		Purchase p =  new Purchase("Coltrane", new BigDecimal(29.99), new GregorianCalendar() );
		Calendar today  = new GregorianCalendar( 2011, Calendar.APRIL, 3 );
		
		ArrayList<Purchase> purchases = new ArrayList<Purchase>();
		purchases.add(p);
		Account account = Account.newInstance( "ed", "ed@ed.com", new GregorianCalendar(2009,Calendar.FEBRUARY,14),new GregorianCalendar(), purchases );
		BigDecimal amt = Loyalty.getDiscountAmount(account, today);
		String result = perFmt.format(amt.doubleValue());
		assertEquals( "10%" , result  );
	}
	
	@Test
	public void usersWhoHaveSpent100OrMoreInLastYearGet20Percent(){
		Purchase p =  new Purchase("Coltrane", new BigDecimal(199.99),  new GregorianCalendar(2010,Calendar.MAY,5) );
		ArrayList<Purchase> purchases = new ArrayList<Purchase>();
		purchases.add(p);
		Account account = Account.newInstance( "ed", "ed@ed.com", new GregorianCalendar(2009,Calendar.FEBRUARY,14), new GregorianCalendar(), purchases );
		BigDecimal amt = Loyalty.getDiscountAmount(account, today);
		String result = perFmt.format(amt.doubleValue());
		assertEquals( "20%" , result  );
	}
	
	@Test
	public void newUsersWhoHaveNotMadePurchasesShouldGet15Percent(){
		Account account = AccountFixture.getNewAccount();
		BigDecimal amt = Loyalty.getDiscountAmount(account, today);
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
	public void fetchTotalPurchasesFromAnAccount(){
		Account account = AccountFixture.getBasicAccount();
		BigDecimal amt = Loyalty.getTotalPurchases(account);
		String result = curFmt.format(amt.doubleValue()) ; 
		assertEquals( "$67.86" , result  );
	}

}
