package org.virtusa.exceptions;

public class StudentNotFoundException extends RuntimeException{
	public StudentNotFoundException(String desc) {
		super(desc);
	}
}
