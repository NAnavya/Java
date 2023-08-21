package org.virtusa.SpringBootMvcDemo.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
	public EmployeeNotFoundException(String desc) {
		super(desc);
	}
}
