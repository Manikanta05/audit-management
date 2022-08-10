package com.cts.audit.severity.pojo;

public class UserCredentials {
	/*
	 * This pojo class is used to obtain details from the User Interface entered by
	 * user
	 */
	private String userId;
	private String password;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserCredentials() {
		super();
	}

	public UserCredentials(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserCredentials [userId=" + userId + ", password=" + password + "]";
	}

}
