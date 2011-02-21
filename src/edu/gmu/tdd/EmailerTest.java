package edu.gmu.tdd;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

public class EmailerTest {
	
	@SuppressWarnings("static-access")
	@Test
	public void sendATonOfTestMockedEmails() {
		//Or could grab  from datastore
	   List<Recipient> recipients = new ArrayList();
	   recipients.add( new Recipient("ed1", "ed1@ed.com") );
	   recipients.add( new Recipient("ed2", "ed2@ed.com") );
	   recipients.add( new Recipient("ed3", "ed3@ed.com") );
	   recipients.add( new Recipient("ed4", "ed4@ed.com") );
		
       Emailer emailer = new Emailer();
       String emailMessage = "Thank your visiting teh inernets! Please come again.";
       
       //define behavior
       EmailMessage email = mock(EmailMessage.class);     
       when( email.newInstance(any(Recipient.class), anyString() ) ).thenReturn(email);
       //inject into object under test
       emailer.setEmailMessage(email);
       
       emailer.sendEmail(recipients, emailMessage );
       verify(email, times(2) ).send();
       
	}
	
	
	@Test
	public void sendATonOfTestEmails() {
		//Or could grab  from datastore
	   List<Recipient> recipients = new ArrayList();
	   recipients.add( new Recipient("ed1", "ed1@ed.com") );
	   recipients.add( new Recipient("ed2", "ed2@ed.com") );
	   recipients.add( new Recipient("ed3", "ed3@ed.com") );
	   recipients.add( new Recipient("ed4", "ed4@ed.com") );
		
       Emailer emailer = new Emailer();
       emailer.sendEmail(recipients, "Thank your visiting teh inernets! Please come again.");
	
	}

}
