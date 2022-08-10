package com.cts.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.auth.model.MyUser;

/**
 * Repository class for storing, fetching and manipulating user data
 */
@Repository
public interface UserRepo extends JpaRepository<MyUser, Integer> {

	// Method to find a user details with user name
	public MyUser findByUserName(String name);
}
