package edu.gmu.tdd;

import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;


public class EmailerTest {
	
	@Test
	public void sendATonOfTestMockedEmails() {
	   List<Recipient> recipients = new ArrayList<Recipient>();
	   recipients.add( new Recipient("ed1", "ed1@ed.com") );
	   recipients.add( new Recipient("ed2", "ed2@ed.com") );
	   recipients.add( new Recipient("ed3", "ed3@ed.com") );
	   recipients.add( new Recipient("ed4", "ed4@ed.com") );
		
       Emailer emailer = new Emailer();
       String emailMessage = "Thank your visiting teh internets! Please come again.";
       
       //instantiate the mock
       EmailMessage email = mock(EmailMessage.class);     
       //define behavior
       when( email.newInstance( any(Recipient.class), anyString() ) ).thenReturn(email);
       
       //inject into object under test
       emailer.setEmailMessage(email);
       
       //exercise object under test
       emailer.sendEmail(recipients, emailMessage);
       
       //verify
       verify(email, times(4) ).send();
	}
	
	
	
}
