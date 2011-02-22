package edu.gmu.tdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class RecipientTest {

	@Test
	public void testRecipient() {
		Recipient recipient = new Recipient("Foo", "foo@bar.com");
		assertEquals( recipient.getName(), "Foo" );
		assertEquals( recipient.getEmail(), "foo@bar.com" );
	}

}
