package com.virtusa.cyberhealth.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BadCredentialsException extends  RuntimeException {
	
	public BadCredentialsException(String message) {
		super(message);

	}

}