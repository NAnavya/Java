package org.virtusa;

import java.util.List;

public class College {
	private int cid;
	private String collegeName;
	private List<String> courses;
	public College() {
		// TODO Auto-generated constructor stub
	}
	public College(int cid, String collegeName, List<String> courses) {
		super();
		this.cid = cid;
		this.collegeName = collegeName;
		this.courses = courses;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	
	
}
