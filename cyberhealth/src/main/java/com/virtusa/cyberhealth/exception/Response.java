package com.virtusa.cyberhealth.exception;

public class Response {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Response(String message) {
		super();
		this.message = message;
	}
	
}
