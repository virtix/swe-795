package edu.gmu.mut.test;

import java.util.logging.Logger;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;


public abstract class BaseTest {

	Logger logger = Logger.getLogger(this.getClass().getName());
	{ 
		BasicConfigurator.configure(); 
	}
}
