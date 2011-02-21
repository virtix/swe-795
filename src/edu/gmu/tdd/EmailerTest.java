package edu.gmu.tdd;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class EmailerTest {
	List<Recipient> recipients;
	
	@Before
	public void setUp(){
		List<Recipient> recipients = new ArrayList();
		recipients.add( new Recipient("ed", "ed@ed.com") );
		recipients.add( new Recipient("ed2", "ed2@ed.com") );
		recipients.add( new Recipient("ed3", "ed3@ed.com") );
		recipients.add( new Recipient("ed4", "ed4@ed.com") );
		recipients.add( new Recipient("ed5", "ed5@ed.com") );
	}
	
	@Test
	public void testSendEmail() throws Throwable {
       Emailer.sendEmail(recipients, "Thank your visiting teh inernets! Please come again.");
	}

}
