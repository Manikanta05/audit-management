package com.cts.auth.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.auth.model.MyUser;
import com.cts.auth.repository.UserRepo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDetailsServiceImplTest {

	@Mock
	UserRepo repo;
	
	@InjectMocks
	UserDetailsServiceImpl userDetailsService;
	
	public void loadUserByUsernameTest() {
		MyUser user = new MyUser(1,"manish","manish123");
		UserDetails loadUserByUsername = userDetailsService.loadUserByUsername("manish");
		assertEquals(user.getUserName(), loadUserByUsername.getUsername());
	}
}
