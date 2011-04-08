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

	NumberFormat curFmt = NumberFormat.getCurrencyInstance();
	NumberFormat perFmt = NumberFormat.getPercentInstance();
	Calendar today = new GregorianCalendar( 2011, Calendar.APRIL, 1 );
	
	
	@Test
	public void reggaeGets15PercentIfPurchasedInLastMonth(){
		Account account = AccountFixture.getBasicAccount(); //purchased reggae in last
		BigDecimal actual = GenreDiscount.getGenreDiscount(account, today, "Reggae");
		assertEquals( "20%" , perFmt.format(actual.doubleValue()) );
	}
	
	
	@Test
	public void genreDiscountIsOfCorrectType(){
		Discount discount = new GenreDiscount();
		assertEquals( "edu.gmu.mut.GenreDiscount", discount.getClass().getCanonicalName() );
	}
	

}
