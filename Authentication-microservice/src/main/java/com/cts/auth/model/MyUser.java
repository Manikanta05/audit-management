package com.cts.auth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Model class for storing user data in database
 *
 */

@Entity(name = "user")
public class MyUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int userId;

	@Column(name = "name")
	@NotBlank(message = "User name cannot be empty from myuser")
	private String userName;

	@NotBlank(message = "Password cannot be blank")
	@Pattern(regexp = "^[A-Za-z0-9]+$")
	private String password;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MyUser(int userId, @NotBlank(message = "User name cannot be empty from myuser") String userName,
			@NotBlank(message = "Password cannot be blank") @Pattern(regexp = "^[A-Za-z0-9]+$") String password) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
	}

	public MyUser() {
		super();
	}

}

