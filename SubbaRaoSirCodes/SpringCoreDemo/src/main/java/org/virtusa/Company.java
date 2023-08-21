package org.virtusa;

public class Company {
	private int cid;
	private String companyName;
	private String companyLoc;
	public Company() {
		// TODO Auto-generated constructor stub
	}
	public Company(int cid, String companyName, String companyLoc) {
		super();
		this.cid = cid;
		this.companyName = companyName;
		this.companyLoc = companyLoc;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyLoc() {
		return companyLoc;
	}
	public void setCompanyLoc(String companyLoc) {
		this.companyLoc = companyLoc;
	}
	

}
