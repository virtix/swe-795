package edu.gmu.mut.test;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import edu.gmu.mut.Account;
import edu.gmu.mut.Loyalty;


public class PurchaseHistoryTest extends BaseTest {
	NumberFormat curFmt = NumberFormat.getCurrencyInstance();
	Calendar today = new GregorianCalendar(2011,Calendar.APRIL,1);

	@Test
	public void shouldGet100DollarsFromAccount(){
		
		Account account = AccountFixture.get100DollarSpenderAccount();
		BigDecimal results = Loyalty.getTotalPurchasesBetweenNowAndNDays( account, today, 365 );
		logger.info(results.toString());
		String actual = curFmt.format(results.doubleValue());
		assertEquals( "$100.00" , actual );
	}

	
	@Test
	public void testThatWeGetCorrectResultsFromPurchasesWithin30Days(){
		
		Account account = AccountFixture.getBasicAccount();
		BigDecimal results = Loyalty.getTotalPurchasesBetweenNowAndNDays( account, today, 30 );
//		logger.info(results.toString());
		String actual = curFmt.format(results.doubleValue());
		assertEquals( "$2.98" , actual );
	}
	
	
	
	
	
	
	
}
