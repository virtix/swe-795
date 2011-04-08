package edu.gmu.mut.test;

import java.util.logging.Logger;

import org.apache.log4j.BasicConfigurator;



public abstract class BaseTest {

	final Logger logger = Logger.getLogger(this.getClass().getName());
	{ 
		BasicConfigurator.configure(); 
	}
}
