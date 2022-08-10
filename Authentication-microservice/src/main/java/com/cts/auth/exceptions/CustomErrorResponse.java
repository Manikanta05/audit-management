package com.cts.auth.exceptions;

import java.time.LocalDateTime;

/**
 * This class is for customizing the exception handler
 */

public class CustomErrorResponse {

	private String message;
	private LocalDateTime dateTime;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public CustomErrorResponse(String message, LocalDateTime dateTime) {
		super();
		this.message = message;
		this.dateTime = dateTime;
	}
	public CustomErrorResponse() {
		super();
	}
	@Override
	public String toString() {
		return "CustomErrorResponse [message=" + message + ", dateTime=" + dateTime + "]";
	}
	
}
