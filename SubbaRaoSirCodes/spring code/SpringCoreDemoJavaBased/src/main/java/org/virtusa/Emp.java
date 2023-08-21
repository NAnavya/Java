package org.virtusa;

public class Emp {
	private int eno;
	private String name;
	private Address address;
	private Company company;
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	public Emp(int eno, String name, Address address, Company company) {
		super();
		this.eno = eno;
		this.name = name;
		this.address = address;
		this.company = company;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	
	
}
