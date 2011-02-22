package edu.gmu.tdd;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


public class EmailContactsDAOTest {

	
    List<Recipient> recipientTestList = new ArrayList<Recipient>();
    
    @Before
    public void setUp(){
    	recipientTestList.add(new Recipient("a1" , "a1@a.com") );
    	recipientTestList.add(new Recipient("a2" , "a2@a.com") );
    	recipientTestList.add(new Recipient("a3" , "a3@a.com") );
    	recipientTestList.add(new Recipient("a4" , "a4@a.com") );
    	recipientTestList.add(new Recipient("a5" , "a5@a.com") );
    }
    

    @Test
	public void staticFetchListOfContactsFromDB() {
		
		EmailContactsDAO dao = mock(EmailContactsDAO.class);
		when( dao.staticFetchRecipients() ).thenReturn( recipientTestList );
		
		List<Recipient> recipients = dao.fetchRecipients();
		
		assertEquals( recipients.size(), 5 );
		
		
	}
    
	@Test
	public void fetchListOfContactsFromDB() {
		
		EmailContactsDAO dao = mock(EmailContactsDAO.class);
		when( dao.fetchRecipients() ).thenReturn( recipientTestList );
		
		List<Recipient> recipients = dao.fetchRecipients();
		
		assertEquals( recipients.size(), 5 );
		
		
	}
}
