package edu.gmu.tdd;

public class DNF {

	public boolean foo(){
		
		boolean a = true;
		boolean b = true;
		boolean c = false;
		boolean d = true;
		
		//DNF equiv: ab V cd
		if( (a && b) || (c && d) ){
		}
		
		return true;
		
	}
	
}
