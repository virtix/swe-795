package edu.gmu.tdd;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;

public class MockitoSmokeTest {

	Logger  log = Logger.getLogger("edu.gmu");
	 static { 
	   BasicConfigurator.configure(); 
	 }
	
	
	@Test
	public void testThatTheMockDoesWhatIExpect(){
		MyInterface myType = mock(MyInterface.class);
		when(myType.foo()).thenReturn("bar");
		String actual = myType.foo();
		log.info( actual );
		assertEquals( actual ,"bar"  );
	}
	

	
	@Test
	public void smoke(){}



}
