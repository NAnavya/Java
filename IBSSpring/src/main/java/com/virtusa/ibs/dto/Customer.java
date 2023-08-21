package com.virtusa.ibs.dto;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	private int acctID;
	private long adhar;
	private String custName;
	private String city;
	private String state;
	private String country;
	private int phoneNo;
	private String password;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int acctID, long adhar, String custName, String city, String state, String country, int phoneNo,
			String password) {
		super();
		this.acctID = acctID;
		this.adhar = adhar;
		this.custName = custName;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phoneNo = phoneNo;
		this.password = password;
	}
	public int getAcctID() {
		return acctID;
	}
	public void setAcctID(int acctID) {
		this.acctID = acctID;
	}
	public long getAdhar() {
		return adhar;
	}
	public void setAdhar(long adhar) {
		this.adhar = adhar;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Customer [acctID=" + acctID + ", adhar=" + adhar + ", custName=" + custName + ", city=" + city
				+ ", state=" + state + ", country=" + country + ", phoneNo=" + phoneNo + ", password=" + password + "]";
	}
	
	
	
	

	
	
	
}