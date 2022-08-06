package com.cts.audit.severity.pojo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.audit.severity.pojo.UserCredentials;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SpringBootTest
@ApiModel(description = "This class is used to test UserCredential Pojo class")
public class UserCredentialsTest {

	@Mock
	UserCredentials user;

	@Test
	@ApiModelProperty(notes = "This method is used to test All argument constructor")
	public void userCredentialsAllConstructorTest() {
		user = new UserCredentials("manikanta", "manikanta123");
		assertEquals("manikanta", user.getUserId());
	}

	@Test
	@ApiModelProperty(notes = "This method is used to test user id")
	public void userIdTest() {
		user = new UserCredentials("manikanta", "manikanta123");
		assertEquals("manikanta", user.getUserId());
	}

	@Test
	@ApiModelProperty(notes = "This method is used to test user password")
	public void passwordTest() {
		user = new UserCredentials("manikanta", "manikanta123");
		assertEquals("manikanta123", user.getPassword());
	}

	@Test
	@ApiModelProperty(notes = "This method is used to test toString()")
	public void toStringTest() {
		String string = user.toString();
		assertEquals(string, user.toString());
	}

	@Test
	@ApiModelProperty(notes = "This method is used to test equal method")
	public void testEqualsMethod() {
		boolean equals = user.equals(user);
		assertTrue(equals);
	}

	@Test
	@ApiModelProperty(notes = "This method is used to test hash code method")
	public void testHashCodeMethod() {
		int hashCode = user.hashCode();
		assertEquals(hashCode, user.hashCode());
	}
}
