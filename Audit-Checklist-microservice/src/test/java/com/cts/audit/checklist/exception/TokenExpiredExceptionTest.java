package com.cts.audit.checklist.exception;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.cts.audit.checklist.exceptions.TokenExpiredException;

import io.swagger.annotations.ApiModel;
@ApiModel(description = "This class is used to test TokenExpiredException")
@SpringBootTest
public class TokenExpiredExceptionTest {


	@Mock
	TokenExpiredException tokenexpired;

	@Test
	public void TokenExpiredExceptionAllConstructorTest() {
		tokenexpired = new TokenExpiredException("Token is expired or Invalid token, please login again!");
		assertEquals("Token is expired or Invalid token, please login again!", tokenexpired.getMessage());
	}

	@Test
	public void toStringTest() {
		String string = tokenexpired.toString();
		assertEquals(string, tokenexpired.toString());
	}

	@Test
	public void testEqualsMethod() {
		boolean equals = tokenexpired.equals(tokenexpired);
		assertTrue(equals);
	}

	@Test
	public void testHashCodeMethod() {
		int hashCode = tokenexpired.hashCode();
		assertEquals(hashCode, tokenexpired.hashCode());
	}
}
