package com.cts.auth.model;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserCredentialsTest {

	@Mock
	UserCredentials user;

	@Before
	public void setUp() {
		user = new UserCredentials();
		user.setUserName("manish");
		user.setPassword("manish123");
	}

	@Test
	public void userCredentialsAllConstructorTest() {
		UserCredentials userCredentials = new UserCredentials("manish", "manish123");
		assertEquals("manish", userCredentials.getUserName());
	}

	@Test
	public void userNameTest() {
		assertEquals("manish", user.getUserName());
	}

	@Test
	public void passwordTest() {
		assertEquals("manish123", user.getPassword());
	}

	@Test
	public void toStringTest() {
		String string = user.toString();
		assertEquals(string, user.toString());
	}

	@Test
	public void testEqualsMethod() {
		boolean equals = user.equals(user);
		assertTrue(equals);
	}

	@Test
	public void testHashCodeMethod() {
		int hashCode = user.hashCode();
		assertEquals(hashCode, user.hashCode());
	}
}
