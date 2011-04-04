package edu.gmu.mut.test;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
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
	
	
	
	
	
	
	
	
	
	//Not sure if using this or a simple Account object is better ...
	public Account stubAccount(String name, String email, Calendar dateRegistered, Calendar lastVisit ){
		Account accnt = mock(Account.class);
		when(accnt.getName()).thenReturn( name );
		when(accnt.getEmail()).thenReturn( email );
		when(accnt.getDateRegistered()).thenReturn( dateRegistered );
		when(accnt.getLastVisitDate()).thenReturn( lastVisit );
		when( accnt.getPurchaseHistory() ).thenReturn( new ArrayList<Purchase>() );
		return accnt;
	}
	
}
