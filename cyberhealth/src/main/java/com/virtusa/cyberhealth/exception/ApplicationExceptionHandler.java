package com.virtusa.cyberhealth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class ApplicationExceptionHandler {
	
	
	
	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<String> handleEmailAlreadyExistsException(EmailAlreadyExistsException emailAlreadyExistsException){
		return new ResponseEntity<>(emailAlreadyExistsException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<String> handleBadCredentialsException(BadCredentialsException badCredentialsException){
		return new ResponseEntity<>(badCredentialsException.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	
	

}