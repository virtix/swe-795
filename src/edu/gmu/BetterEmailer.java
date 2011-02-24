package edu.gmu;

import java.util.List;

public class BetterEmailer {
	
	/**
	 * Creates a real EmailService by default with the option of
	 * using a different one.
	 *  
	 */
	EmailService service = new EmailService();
	
	public void setEmailService(EmailService service) {
		this.service = service;
	}
	
	public void sendEmail(List<Recipient> recipients, String message){
	    service.connect();
	    for(Recipient recipient : recipients){
		    service.send( recipient, message );
	    }
	    service.close();
	}

}
