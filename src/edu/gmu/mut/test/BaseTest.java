package edu.gmu.mut.test;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

import org.apache.log4j.BasicConfigurator;



public abstract class BaseTest {

	final Logger logger = Logger.getLogger(this.getClass().getName());
	NumberFormat curFmt = NumberFormat.getCurrencyInstance();
	protected NumberFormat perFmt = NumberFormat.getPercentInstance();
	protected Calendar today = new GregorianCalendar( 2011, Calendar.APRIL, 1 );
	{ 
		BasicConfigurator.configure(); 
	}
}
