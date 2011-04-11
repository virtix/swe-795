package edu.gmu.mut.test;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import edu.gmu.mut.Account;
import edu.gmu.mut.Purchase;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class AccountTest extends BaseTest {
	
	
	@Test
	public void accountInstantiationTest(){
		
		Account account = AccountFixture.getBasicAccount();

		Calendar regDate;
		Calendar visitDate;
		regDate = new GregorianCalendar(2011,Calendar.JANUARY,1);
		visitDate = new GregorianCalendar(2011,Calendar.MARCH,1);
		
		assertEquals( "bill" , account.getName() );
		assertEquals( "bill@if.io" , account.getEmail() );
		assertEquals( regDate, account.getDateRegistered() );
		assertEquals( visitDate, account.getLastVisitDate() );
	    logger.info( DateFormat.getInstance().format( regDate.getTime() ) );
	}
	
	
	
		
	/*
	 * Mutation - driven tests
	 */
	@Test
	public void test3(){
		ArrayList purchase = new ArrayList();
		ArrayList purchase1 = new ArrayList();
		purchase1.add( new Purchase("Reggae", new BigDecimal( .99), new GregorianCalendar(2011, Calendar.MARCH, 5)  ));
		Calendar regDate;
		Calendar visitDate;
		regDate = new GregorianCalendar(2011,Calendar.JANUARY,1);
		visitDate = new GregorianCalendar(2011,Calendar.MARCH,1);
		Calendar regDate1;
		Calendar visitDate1;
		regDate1 = new GregorianCalendar(2010,Calendar.JANUARY,2);
		visitDate1 = new GregorianCalendar(2010,Calendar.MARCH,3);
		Account account = Account.newInstance("bill", "bill@if.io", regDate, visitDate, purchase);
		Account account1 = Account.newInstance("Nan", "NAN@if.io", regDate1, visitDate1, purchase1);
		assertEquals(account.getName(), account1.getName());
		assertEquals(account.getEmail(), account1.getEmail());
		assertEquals(account.getDateRegistered(), account1.getDateRegistered());
		assertEquals(account.getLastVisitDate(), account1.getLastVisitDate());
		assertEquals(account.getPurchaseHistory(), account1.getPurchaseHistory());
	}
	
}
