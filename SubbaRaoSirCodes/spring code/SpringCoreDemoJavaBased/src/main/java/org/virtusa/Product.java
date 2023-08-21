package org.virtusa;

public class Product {
	private int pid;
	private String name;
	private String description;
	private int price;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(int pid, String name, String description, int price) {
		super();
		this.pid = pid;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
