package org.virtusa.app.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("FT")
public class FulltimeEmployee extends Employee{
	private int noOfDays;
	public FulltimeEmployee() {
		// TODO Auto-generated constructor stub
	}
	public FulltimeEmployee(int noOfDays) {
		super();
		this.noOfDays = noOfDays;
	}
	public int getNoOfDays() {
		return noOfDays;
	}
	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}
	
}
