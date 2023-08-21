package com.virtusa.cyberhealth.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmailAlreadyExistsException  extends RuntimeException {
	
	public EmailAlreadyExistsException(String message) {
		super(message);

	}

}