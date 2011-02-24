package edu.gmu;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class EmailerTest {
	
	List<Recipient> recipients = Arrays.asList(
			   new Recipient("Ed One",   "ed1@ed.com"),
			   new Recipient("Ed Two",   "ed2@ed.com"),
			   new Recipient("Ed Three", "ed3@ed.com"),
			   new Recipient("Ed Four",  "ed4@ed.com")
 	);
		
	
	
	/**
	 *  No mocks. (And not really much of a test)
	 * 
	 * 	How would "you" test a method that returns void?
	 * 
	 * */
	@Test
	public void shouldUseDefaultEmailer() {
		Emailer emailer = new Emailer();
		emailer.sendEmail(recipients, "Thank you for visiting teh internets!");
	}
	
	
	
	/**
	 *  Using Improved BetterEmailer but has same effect.
	 *  
	 *  Still not a very good test. 
	 * 
	 * */
	@Test
	public void shouldUseBetterEmailer() {
		BetterEmailer emailer = new BetterEmailer();
		emailer.sendEmail(recipients, "Thank you for visiting teh internets!");
	}
	
	
	/**
	 *  Inject mock into object under test. And verify calls. Much better test.
	 * 
	 * */
	@Test
	public void handBuiltFakeSpamExample() {
		BetterEmailer emailer = new BetterEmailer();
	    
		//Create an in-line fake object.
		EmailService fakeService = new EmailService(){
				@Override
				public void connect(){
					System.out.println("connecting fake.");
				}
				
				@Override
				public void close(){
					System.out.println("closing fake.");
				}
			
				@Override
				public void send(Recipient recipient, String message){
					System.out.println("Yeah, ya got here, " + recipient);
				}
		};
		
		
		//Kills side effects, but now what?
		emailer.setEmailService(fakeService);
		
		//exercise object under test
		emailer.sendEmail(recipients, "Thank you for visiting teh internets!");
		
	}
	
	
	
	/**
	 *  Inject mock into object under test. And verify calls. Much better test.
	 * 
	 * */
	@Test
	public void injectedMockSpamExample() {
		BetterEmailer emailer = new BetterEmailer();
		
		//Create a mock email service
		EmailService mockService = mock(EmailService.class);
		
		//Inject emailer with mock
		//emailer.setEmailService( mockService );
		
		emailer.setEmailService(mockService);
		
		//exercise object under test
		emailer.sendEmail(recipients, "Thank you for visiting teh internets!");
		
		//Perform verifications
		
		//Verify correct number of calls (intentionally out of order for demo)
		verify(mockService, times(4)).send( any(Recipient.class), anyString() );
		verify(mockService).close();
		verify(mockService).connect();
		
		
		//Verify number AND order
		InOrder inOrder = inOrder(mockService);
		inOrder.verify(mockService).connect();
		inOrder.verify(mockService, times(4)).send( any(Recipient.class), anyString() );
		inOrder.verify(mockService).close();
	}
	

	
	//Or can create inner class
	class FakeEmailService extends EmailService {
		@Override
		public void connect(){}
		
		@Override
		public void close(){}
	
		@Override
		public void send(Recipient recipient, String message){
			System.out.print("Yeah, ya got here, " + recipient + "\n");
		}
	}
	
}
