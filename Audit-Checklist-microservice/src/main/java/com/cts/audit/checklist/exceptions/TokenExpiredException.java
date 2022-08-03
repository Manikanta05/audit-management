package com.cts.audit.checklist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TokenExpiredException extends RuntimeException {

	public TokenExpiredException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
