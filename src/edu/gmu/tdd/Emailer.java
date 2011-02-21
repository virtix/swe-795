package edu.gmu.tdd;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Emailer {

	static Logger logger = Logger.getLogger("edu.gmu");	
	static { 
	  BasicConfigurator.configure(); 
	}

	
	EmailMessage email = new EmailMessage();
	
	public void setEmailMessage(EmailMessage email){
		this.email = email;
	}

	
	
	public void sendEmail(List<Recipient> recipients, String message) {
		
		for(Recipient recipient : recipients){
			EmailMessage email = this.email.newInstance( recipient, message );
			try{
				email.send();
			} 
			catch(Throwable t){
				logger.error("Unable to send email to " + recipient, t);
			}
		}

	}
	
	
	
} //end class
