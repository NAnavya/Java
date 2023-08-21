package com.virtusa.cyberhealth.dto;

public class UserDto {
	int id;
	String email;
	String password;
	String confirmpassword;
	String mobileNumber;
	String username;
	boolean active;
	public String role;
	String specialization;
	int bookingId;
	int prescriptionId;
	boolean loggedIn;
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(int id, String email, String password, String confirmpassword, String mobileNumber, String username,
			boolean active, String role, String specialization, int bookingId, int prescriptionId,boolean loggedIn) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.mobileNumber = mobileNumber;
		this.username = username;
		this.active = active;
		this.role = role;
		this.specialization = specialization;
		this.bookingId = bookingId;
		this.prescriptionId = prescriptionId;
		this.loggedIn=loggedIn;
	}
	
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", email=" + email + ", password=" + password + ", confirmpassword="
				+ confirmpassword + ", mobileNumber=" + mobileNumber + ", username=" + username + ", active=" + active
				+ ", role=" + role + ", specialization=" + specialization + ", bookingId=" + bookingId
				+ ", prescriptionId=" + prescriptionId + "]";
	}
	
}
