package edu.gmu.mut.test;

import  org.junit.runner.RunWith;
import  org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses( { PurchaseTest.class,
					   AccountTest.class,
					   LoyaltyDiscountTest.class,
					   SpikesTest.class,
					   DateSpikeTest.class,
					   GenreDiscountTest.class
					  } )
					  
public class AllTests {}
