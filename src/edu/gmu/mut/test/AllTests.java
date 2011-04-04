package edu.gmu.mut.test;

import  org.junit.runner.RunWith;
import  org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses( { PurchaseTest.class,
					   AccountTest.class,
					   LoyaltyTest.class
					  } ) 
public class AllTests {

	
}
