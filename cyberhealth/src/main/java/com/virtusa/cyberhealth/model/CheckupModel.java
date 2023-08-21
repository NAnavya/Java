package com.virtusa.cyberhealth.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="checkup_details")
public class CheckupModel {
	@Id
	@Column(name="checkupid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int checkupID;
	
	@Column(name="patientId")
	int patientId;
	
	@Column(name="bookingId")
	int bookingId;
	
	@Column(name="did")
	int did;
	
	@Column(name="disease")
	String disease;
	
	@Column(name="description")
	String description;
	
	

	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}

	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public int getCheckupID() {
		return checkupID;
	}
	public void setCheckupID(int checkupID) {
		this.checkupID = checkupID;
	}

	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


}