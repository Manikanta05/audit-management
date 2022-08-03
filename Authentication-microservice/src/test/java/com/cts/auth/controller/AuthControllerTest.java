package com.cts.auth.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

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
	
	

}
