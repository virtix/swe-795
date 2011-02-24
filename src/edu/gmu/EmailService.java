package edu.gmu;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 *  A thin wrapper for some external email dependency/service
 * 
 * */
public class EmailService {

	Logger logger = Logger.getLogger(EmailService.class);
	{
		BasicConfigurator.configure();
	}
	
	
	public void connect() {
		logger.info("connect()");
	}

	
	public void send(Recipient recipient, String message) {
		logger.info("Spamming : " + recipient);
	}

	
	public void close() {
		logger.info("close()");		
	}

	
} //end class
