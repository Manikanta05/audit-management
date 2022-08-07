package com.cts.audit.severity.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import com.cts.audit.severity.exceptions.TokenNotValidException;

class TokenNotValidExceptionTest {

	@Mock
	TokenNotValidException tokenNotValidException;

	@Test
	public void testOneArgConstructor() {
		 tokenNotValidException = new TokenNotValidException("Invalid Token!");
		assertEquals("Invalid Token!", tokenNotValidException.getMessage());
	}

}
