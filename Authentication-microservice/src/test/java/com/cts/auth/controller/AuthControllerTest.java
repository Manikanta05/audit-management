package com.cts.auth.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Optional;

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
import com.cts.auth.model.MyUser;
import com.cts.auth.model.UserCredentials;
import com.cts.auth.repository.UserRepo;
import com.cts.auth.service.UserDetailsServiceImpl;
import com.cts.auth.util.JwtUtil;

/**
 * Test - AuthController class
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AuthControllerTest {

	@InjectMocks
	AuthController authController;
	
	@Mock
	JwtUtil jwtutil;

	@Mock
	UserDetailsServiceImpl custdetailservice;

	@Mock
	UserRepo userservice;

	@Test
	public void validLoginTest() {

		UserCredentials user = new UserCredentials("manish", "manish123");
		UserDetails value = new User(user.getUserName(), user.getPassword(), new ArrayList<>());
		when(custdetailservice.loadUserByUsername("manish")).thenReturn(value);
		when(jwtutil.generateToken(user.getUserName())).thenReturn("token");
		String login = authController.login(user);
		assertEquals("token", login);
	}

	@Test(expected = UserNotFoundException.class)
	public void nullUserNameLoginTest() {
		UserCredentials user = new UserCredentials(null, "manish");
		authController.login(user);

	}

	@Test(expected = UserNotFoundException.class)
	public void nullPasswordLoginTest() {
		UserCredentials user = new UserCredentials("manish", null);
		authController.login(user);

	}

	@Test(expected = UserNotFoundException.class)
	public void emptyPasswordLoginTest() {
		UserCredentials user = new UserCredentials("manish", "");
		authController.login(user);

	}

	@Test(expected = UserNotFoundException.class)
	public void emptyUserNameLoginTest() {
		UserCredentials user = new UserCredentials("", "manish123");
		authController.login(user);

	}

	@Test(expected = UserNameNumericException.class)
	public void userNameNumericLoginTest() {
		when(jwtutil.isNumeric("123")).thenReturn(true);
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

		when(jwtutil.validateToken("token", value)).thenReturn(true);
		when(jwtutil.extractUsername("token")).thenReturn("manish");

		MyUser user1 = new MyUser(1, "manish", "manish123");
		Optional<MyUser> data = Optional.of(user1);

		when(userservice.findById(1)).thenReturn(data);

		ResponseEntity<?> validity = authController.validate("Bearer token");

		assertEquals(false, validity.getBody().toString().contains("true"));

	}

	@Test
	public void validateTestInValidUsertoken() {

		UserCredentials user = new UserCredentials("admin", "admin");
		UserDetails value = new User(user.getUserName(), "admin", new ArrayList<>());

		when(jwtutil.validateToken("token1", value)).thenReturn(false);

		ResponseEntity<?> validity = authController.validate("Bearer token1");

		assertEquals(true, validity.getBody().toString().contains("false"));

	}

	@Test
	public void validateTestInValidtoken() {

		UserCredentials user = new UserCredentials("manish", "manish123");
		UserDetails value = new User(user.getUserName(), "manish123", new ArrayList<>());

		when(jwtutil.validateToken("token", value)).thenReturn(false);

		ResponseEntity<?> validity = authController.validate("bearer token");

		assertEquals(true, validity.getBody().toString().contains("false"));

	}

	@Test
	public void testHealthCheck(){
		assertEquals(200,authController.healthCheck().getStatusCodeValue());
	}

}
