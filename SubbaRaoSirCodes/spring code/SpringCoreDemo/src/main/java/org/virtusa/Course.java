package org.virtusa;

public class Course {
	private int cid;
	private String courseName;
	private int price;
	public Course() {
		// TODO Auto-generated constructor stub
	}
	public Course(int cid, String courseName, int price) {
		super();
		this.cid = cid;
		this.courseName = courseName;
		this.price = price;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
