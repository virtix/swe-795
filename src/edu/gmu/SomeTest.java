package edu.gmu;

import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
 
@RunWith(Theories.class)
public class SomeTest {
	public static @DataPoints int[] values = {1,2,3,4};
    static int count=0;
	
	@Theory
	public void testTheNewTheoriesStuff(int x, int y, int z) {
		System.out.println( ++count + " = " + "(" + x + "," + y  + "," + z + ")" );
	}
 
}
