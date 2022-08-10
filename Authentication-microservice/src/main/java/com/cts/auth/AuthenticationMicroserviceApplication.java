package com.cts.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cts.auth.model.MyUser;
import com.cts.auth.repository.UserRepo;

@SpringBootApplication
public class AuthenticationMicroserviceApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationMicroserviceApplication.class, args);
	}
	
	@Autowired
	private UserRepo repo;

	@Override
	public void run(String... args) throws Exception {
		repo.save(new MyUser(1,"akansha","akansha123"));
		repo.save(new MyUser(2,"sinchana","sinchana123"));
		repo.save(new MyUser(3,"manikanta","manikanta123"));
		repo.save(new MyUser(4,"manish","manish123"));
	}

}
