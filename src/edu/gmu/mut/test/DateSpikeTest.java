package edu.gmu.mut.test;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class DateSpikeTest extends BaseTest {

	
	@Test
	public void whatDoesOneYearOldLookLike(){
		Calendar regDate = new GregorianCalendar( 2010, Calendar.MAY, 5 );
		Calendar   today = new GregorianCalendar( 2011, Calendar.APRIL, 4 );
       	
		long today_ms = today.getTimeInMillis();
		long reg_ms = regDate.getTimeInMillis();
		
		long diff_days = (today_ms-reg_ms) / (24 * 60 * 60 * 1000); 
		
//		Calendar diff = new Gre
		
		System.out.println ( diff_days );
		
		assertEquals( 334, diff_days );
		
		
	}
	
	
	
	@Test
	public final void dateAddTest() {
		Calendar regDate = new GregorianCalendar( 2010, Calendar.MAY, 5 );
		regDate.add(Calendar.DAY_OF_MONTH, -30);
		logger.info( DateFormat.getDateInstance().format(regDate.getTime()) );
	}

}
