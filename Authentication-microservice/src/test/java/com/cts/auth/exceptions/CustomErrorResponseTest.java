package com.cts.auth.exceptions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test - CustomErrorResponse class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomErrorResponseTest {

	@Mock
	CustomErrorResponse customErrorResponse;

	@Before
	public void setUp() {
		customErrorResponse = new CustomErrorResponse();
		customErrorResponse.setDateTime(LocalDateTime.now());
		customErrorResponse.setMessage("Custom error response");
	}

	@Test
	public void CustomErrorResponseAllConstructorTest() {
		CustomErrorResponse customErrorResponse = new CustomErrorResponse("Custom error response", LocalDateTime.now());
		assertEquals("Custom error response", customErrorResponse.getMessage());
	}

	@Test
	public void messageTest() {
		assertEquals("Custom error response", customErrorResponse.getMessage());
	}

	@Test
	public void dateTimeTest() {
		customErrorResponse.setDateTime(LocalDateTime.now());
		assertEquals(LocalDateTime.now(), customErrorResponse.getDateTime());
	}

	@Test
	public void toStringTest() {
		String string = customErrorResponse.toString();
		assertEquals(string, customErrorResponse.toString());
	}

	@Test
	public void testEqualsMethod() {
		boolean equals = customErrorResponse.equals(customErrorResponse);
		assertTrue(equals);
	}

	@Test
	public void testHashCodeMethod() {
		int hashCode = customErrorResponse.hashCode();
		assertEquals(hashCode, customErrorResponse.hashCode());
	}
}
