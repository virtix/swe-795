package edu.gmu.mut.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import org.junit.Test;

import edu.gmu.mut.Account;
import edu.gmu.mut.Purchase;

public class LoyaltyTest {

	Calendar regDate= new GregorianCalendar(2011,Calendar.JANUARY,1);
	Calendar visitDate = new GregorianCalendar(2011,Calendar.MARCH,1);
	ArrayList<Purchase> purchases;
	Account account = Account.newInstance("bill", "bill@if.io", regDate, visitDate, purchases );

	
	@Test
	public void testSimpleCreateLoyaltyDicount(){
		//Loyalty loyalty = new Loyalty(  );
	}
}
