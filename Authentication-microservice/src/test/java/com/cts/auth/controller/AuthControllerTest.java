package com.cts.auth.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.auth.exceptions.UserNameNumericException;
import com.cts.auth.exceptions.UserNotFoundException;
import com.cts.auth.model.UserCredentials;
import com.cts.auth.service.UserDetailsServiceImpl;
import com.cts.auth.util.JwtUtil;

@SpringBootTest
@RunWith(SpringRunner.class)
class AuthControllerTest {

	@InjectMocks
	AuthController authController;
	
	UserDetails userDetails;
	
	@Mock
	JwtUtil jwtUtil;
	
	@Mock
	UserDetailsServiceImpl userDetailsService;
	
	
	@Test
	public void loginTest() {
		UserCredentials user = new UserCredentials("manish","manish123");
		userDetails = new User(user.getUserName(),user.getPassword(),new ArrayList<>());
		when(userDetailsService.loadUserByUsername("manish")).thenReturn(userDetails);
		when(jwtUtil.generateToken(user.getUserName())).thenReturn("token");
		assertEquals("token", authController.login(user));
	}
	
	
	@Test(expected=UserNotFoundException.class)
	public void NullUsernameTest() {
		UserCredentials user = new UserCredentials(null,"manish123");
		authController.login(user);
	}
	
	@Test(expected = UserNotFoundException.class)
	public void nullPasswordLoginTest() {
		UserCredentials user = new UserCredentials("admin", null);
		authController.login(user);

	}

	@Test(expected = UserNotFoundException.class)
	public void emptyPasswordLoginTest() {
		UserCredentials user = new UserCredentials("admin", "");
		authController.login(user);

	}

	@Test(expected = UserNotFoundException.class)
	public void emptyUserNameLoginTest() {
		UserCredentials user = new UserCredentials("", "admin");
		authController.login(user);

	}

	@Test(expected = UserNameNumericException.class)
	public void userNameNumericLoginTest() {
		when(jwtUtil.isNumeric("123")).thenReturn(true);
		UserCredentials user = new UserCredentials("123", "abc");
		authController.login(user);

	}

	@Test
	public void userNameNotFoundLoginTest() {
		UserCredentials user = new UserCredentials("123", "abc");
		Exception exception = assertThrows(UserNotFoundException.class, () -> {
			authController.login(user);
		});

		String expectedMessage = "Invalid Credential";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));

	}
	
	@Test
	public void validateTestValidtoken() {

		UserCredentials user = new UserCredentials("manish", "manish123");
		UserDetails value = new User(user.getUserName(), "manish", new ArrayList<>());

		when(jwtUtil.validateToken("token", value)).thenReturn(true);
		when(jwtUtil.extractUsername("token")).thenReturn("manish");

		when(userDetailsService.loadUserByUsername("manish")).thenReturn(value);

		ResponseEntity<?> validity = authController.validate("Bearer token");

		assertEquals(false, validity.getBody().toString().contains("true"));

	}

	@Test
	public void validateTestInValidUsertoken() {

		UserCredentials user = new UserCredentials("manish", "manish123");
		UserDetails value = new User(user.getUserName(), "manish", new ArrayList<>());

		when(jwtUtil.validateToken("token1", value)).thenReturn(false);

		ResponseEntity<?> validity = authController.validate("Bearer token1");

		assertEquals(true, validity.getBody().toString().contains("false"));

	}

	@Test
	public void validateTestInValidtoken() {

		UserCredentials user = new UserCredentials("admin", "admin");
		UserDetails value = new User(user.getUserName(), "admin", new ArrayList<>());

		when(jwtUtil.validateToken("token", value)).thenReturn(false);

		ResponseEntity<?> validity = authController.validate("bearer token");

		assertEquals(true, validity.getBody().toString().contains("false"));

	}

	@Test
	public void testHealthCheck(){
		assertEquals(200,authController.healthCheck().getStatusCodeValue());
	}

}
