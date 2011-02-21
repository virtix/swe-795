package edu.gmu.tdd;

import java.util.List;

public class Emailer {

	
	public static boolean sendEmail(List<Recipient> recipients, String message) throws Throwable {
		
		for(Recipient recipient : recipients){
			 EmailMessage email = new EmailMessage( recipient, message );
			 email.send();
		}
		
		return true;
	}
	
}
