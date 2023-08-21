package org.virtusa.app.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PT")
public class ParttimeEmployee extends Employee{
	int noOfHours;
	public ParttimeEmployee() {
		// TODO Auto-generated constructor stub
	}
	public ParttimeEmployee(int noOfHours) {
		super();
		this.noOfHours = noOfHours;
	}
	public int getNoOfHours() {
		return noOfHours;
	}
	public void setNoOfHours(int noOfHours) {
		this.noOfHours = noOfHours;
	}
	
	
}
