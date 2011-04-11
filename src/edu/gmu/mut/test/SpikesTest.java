package edu.gmu.mut.test;

import static org.junit.Assert.*;

import org.junit.Test;
import edu.gmu.mut.LoyaltyDiscount;

import java.math.BigDecimal;
import java.text.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class SpikesTest extends BaseTest {

	@Test
	public void calcDayDelta(){
		Calendar regDate = new GregorianCalendar( 2010, Calendar.MAY, 5 );
		Calendar   today = new GregorianCalendar( 2011, Calendar.APRIL, 4 );
		long actualDiff = LoyaltyDiscount.computeDeltaDays( today, regDate );
		assertEquals( 334, actualDiff );
	}

	
	@Test
	public void dateCompareTestSpike(){
		GregorianCalendar cal1 = new GregorianCalendar(2010,1,1);
		GregorianCalendar cal2 = new GregorianCalendar();
    	  assertTrue( cal1.before(cal2) );
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
