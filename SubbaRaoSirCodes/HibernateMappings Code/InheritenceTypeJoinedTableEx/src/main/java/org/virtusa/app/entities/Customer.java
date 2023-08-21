package org.virtusa.app.entities;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(name="cust_id")
@Entity
public class Customer extends Person{
	private String orderName;
	private int amount;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String orderName, int amount) {
		super();
		this.orderName = orderName;
		this.amount = amount;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
}
