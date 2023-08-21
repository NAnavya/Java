package com.virtusa.cyberhealth.model;

import java.sql.Date;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="prescription_details")
public class PrescriptionModel {
	
	@Id
	@Column(name="prescriptionId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int prescriptionId;
	
	@Column(name="did")
	int did;
	
	@Column(name="bookingId")
	int bookingId;
	


	@ManyToOne
	 @JoinColumn(name="patientId")
	UserModel usermodel;
	
	@Column(name="date")
	@JsonFormat(pattern = "yyyy/MM/dd")
	Date date;
	
	
	
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	@Column(name="medicine")
	String medicine;
	
	String dose;

	public int getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}


	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}





	public UserModel getUsermodel() {
		return usermodel;
	}

	public void setUsermodel(UserModel usermodel) {
		this.usermodel = usermodel;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	
	

}