package edu.gmu.mut;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class AccountTest extends BaseTest {

	Calendar regDate;
	Calendar visitDate;
	Account account;
	ArrayList<Purchase> purchases;

	@Before
	public void setUp(){
		regDate = new GregorianCalendar(2011,Calendar.JANUARY,1);
		visitDate = new GregorianCalendar(2011,Calendar.MARCH,1);
		account = Account.newInstance("bill", "bill@if.io", regDate, visitDate );
	}
	
	
	@Test
	public void accountInstantiationTest(){
		assertEquals( "bill" , account.getName() );
		assertEquals( "bill@if.io" , account.getEmail() );
		assertEquals( regDate, account.getDateRegistered() );
		assertEquals( visitDate, account.getLastVisitDate() );
	    logger.info( DateFormat.getInstance().format( regDate.getTime() ) );
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Not sure if using this or a simple Account object is better ...
	public IAccount stubAccount(String name, String email, Calendar dateRegistered, Calendar lastVisit ){
		IAccount accnt = mock(IAccount.class);
		when(accnt.getName()).thenReturn( name );
		when(accnt.getEmail()).thenReturn( email );
		when(accnt.getDateRegistered()).thenReturn( dateRegistered );
		when(accnt.getLastVisitDate()).thenReturn( lastVisit );
		when( accnt.getPurchaseHistory() ).thenReturn( new ArrayList<Purchase>() );
		return accnt;
	}
	
}
