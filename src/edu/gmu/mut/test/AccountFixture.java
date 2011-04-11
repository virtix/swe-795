package edu.gmu.mut.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import edu.gmu.mut.Account;
import edu.gmu.mut.Purchase;

public class AccountFixture {

	
	public static Account get100DollarSpenderAccount(){
		Calendar regDate;
		Calendar visitDate;
		ArrayList<Purchase> purchases ;
		purchases = new ArrayList();
		Purchase p = new Purchase("Blues", new BigDecimal(100.00), new GregorianCalendar(2010,Calendar.NOVEMBER,24));
		purchases.add(p);
		regDate = new GregorianCalendar(2011,Calendar.MARCH,15);
		visitDate = new GregorianCalendar(2011,Calendar.MARCH,20);
		return Account.newInstance("100$_bill", "100$_bill@if.io", regDate, visitDate, purchases );
	}
	
	public static Account getNewAccount(){
		Calendar regDate;
		Calendar visitDate;
		ArrayList<Purchase> purchases ;
		purchases = new ArrayList();
		regDate = new GregorianCalendar(2011,Calendar.MARCH,15);
		visitDate = new GregorianCalendar(2011,Calendar.MARCH,20);
		return Account.newInstance("new bill", "new_bill@if.io", regDate, visitDate, purchases );
	}

	
	
	public static Account getBasicAccount(){
		Calendar regDate;
		Calendar visitDate;
		ArrayList<Purchase> purchases ;
		purchases = new ArrayList();
		purchases.add( new Purchase("Reggae", new BigDecimal( .99), new GregorianCalendar(2011, Calendar.MARCH, 5)  ));
		purchases.add( new Purchase("Reggae", new BigDecimal( 1.99), new GregorianCalendar(2011, Calendar.MARCH, 5)  ));
		purchases.add( new Purchase("Jazz", new BigDecimal( 9.99), new GregorianCalendar(2011, Calendar.JANUARY, 5)  ));
		purchases.add( new Purchase("Jazz", new BigDecimal(4.99), new GregorianCalendar(2010, Calendar.FEBRUARY, 4)  ));
		purchases.add( new Purchase("Punk", new BigDecimal(1.99), new GregorianCalendar(2010, Calendar.MARCH, 4) ));
		purchases.add( new Purchase("Rock", new BigDecimal(2.99), new GregorianCalendar(2010, Calendar.APRIL, 5)  ));
		purchases.add( new Purchase("Rock", new BigDecimal(3.99), new GregorianCalendar(2010, Calendar.MAY, 4)  ));
		purchases.add( new Purchase("Blues", new BigDecimal(4.99), new GregorianCalendar(2010, Calendar.JUNE, 12)  ));
		purchases.add( new Purchase("Classical", new BigDecimal(12.99), new GregorianCalendar(2010, Calendar.JULY, 22)  ));
		purchases.add( new Purchase("Oldies", new BigDecimal(2.99), new GregorianCalendar(2010, Calendar.AUGUST, 4)  ));
		purchases.add( new Purchase("Rock", new BigDecimal(4.99), new GregorianCalendar(2010, Calendar.SEPTEMBER, 25)  ));
		purchases.add( new Purchase("Latin", new BigDecimal(4.99), new GregorianCalendar(2010, Calendar.OCTOBER, 1)  ));
		purchases.add( new Purchase("Eclectic", new BigDecimal(4.99), new GregorianCalendar(2010, Calendar.NOVEMBER, 28)  ));
		purchases.add( new Purchase("Eclectic", new BigDecimal(4.99), new GregorianCalendar(2010, Calendar.DECEMBER, 20)  ));
		
		regDate = new GregorianCalendar(2011,Calendar.JANUARY,1);
		visitDate = new GregorianCalendar(2011,Calendar.MARCH,1);
		return Account.newInstance("bill", "bill@if.io", regDate, visitDate, purchases );
	}
	
}
