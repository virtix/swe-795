package edu.gmu;

public class Recipient {

	String name;
	String email;

	public Recipient(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String toString(){
		return name + " <" + email + ">";
		
	}
}
