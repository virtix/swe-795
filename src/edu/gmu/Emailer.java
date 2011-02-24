package edu.gmu;

import java.util.List;

public class Emailer {
	
	public void sendEmail(List<Recipient> recipients, String message){
	    EmailService service = new EmailService();
	    service.connect();
	    for(Recipient recipient : recipients){
		   service.send( recipient, message );
	    }
	    service.close();
	}

}
