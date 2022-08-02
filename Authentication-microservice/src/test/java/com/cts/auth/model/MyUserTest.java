package com.cts.auth.model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class MyUserTest {

	@Mock
	MyUser myUser;

	@Before
	public void setUp() {
		myUser = new MyUser();
		myUser.setUserId(1);
		myUser.setUserName("manish");
		myUser.setPassword("manish123");
	}

	@Test
	public void userCredentialsAllConstructorTest() {
		MyUser user = new MyUser(1, "manish", "manish123");
		assertEquals("manish", user.getUserName());
	}

	@Test
	public void userIdTest() {
		assertEquals(1, myUser.getUserId());
	}

	@Test
	public void userNameTest() {
		assertEquals("manish", myUser.getUserName());
	}

	@Test
	public void passwordTest() {
		assertEquals("manish123", myUser.getPassword());
	}

	@Test
	public void toStringTest() {
		String string = myUser.toString();
		assertEquals(string, myUser.toString());
	}

	@Test
	public void testEqualsMethod() {
		boolean equals = myUser.equals(myUser);
		assertTrue(equals);
	}

	@Test
	public void testHashCodeMethod() {
		int hashCode = myUser.hashCode();
		assertEquals(hashCode, myUser.hashCode());
	}
}
