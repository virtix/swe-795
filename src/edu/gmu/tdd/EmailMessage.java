package edu.gmu.tdd;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class EmailMessage {

	static Logger log = Logger.getLogger("edu.gmu");	
	static { 
	  BasicConfigurator.configure(); 
	}

	
	public EmailMessage(Recipient recipient, String message) {
		// TODO Auto-generated constructor stub
	}

	public EmailMessage() {
		// TODO Auto-generated constructor stub
	}

	public void send() {
		log.info("Sending message to : UNKNOWN" );
		
	}

	public EmailMessage newInstance(Recipient recipient, String message) {
		return new EmailMessage(recipient,message);
	}

}
