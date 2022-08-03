package com.cts.auth.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JwtUtilTest {

	UserDetails userDetails;

	@InjectMocks
	JwtUtil jwtUtil;

	@Test
	public void isNumericTrueTest() {
		String num = "123";
		assertEquals(true, jwtUtil.isNumeric(num));
	}

	@Test
	public void isNumericNullTest() {
		String num = null;
		assertEquals(false, jwtUtil.isNumeric(num));
	}

	@Test
	public void isNumericFalseTest() {
		String num = "abc";
		assertEquals(false, jwtUtil.isNumeric(num));
	}

	@Test
	public void generateTokenTest() {
		userDetails = new User("manish", "manish123", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails.getUsername());
		assertNotNull(generateToken);
	}

	@Test
	public void validateTokenTest() {
		userDetails = new User("manish", "manish123", new ArrayList<>());
		String generateToken = jwtUtil.generateToken(userDetails.getUsername());
		boolean validateToken = jwtUtil.validateToken(generateToken, userDetails);
		assertEquals(true, validateToken);
	}
	
}
