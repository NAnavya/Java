package org.virtusa.app.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name="emp_id")
@Entity
public class Employee extends Person{
	private int sal;
	private String designation;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(int sal, String designation) {
		super();
		this.sal = sal;
		this.designation = designation;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
