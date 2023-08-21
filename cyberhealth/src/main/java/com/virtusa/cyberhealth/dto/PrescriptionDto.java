package com.virtusa.cyberhealth.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PrescriptionDto {
     int prescriptionId;
     int did;
     int bookingId;
     int patientId;
 	@JsonFormat(pattern = "yyyy/MM/dd")
     Date date;
     String medicine;
     String dose;
     
	public PrescriptionDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PrescriptionDto(int prescriptionId, int did, int bookingId, int patientId, Date date, String medicine,
			String dose) {
		super();
		this.prescriptionId = prescriptionId;
		this.did = did;
		this.bookingId = bookingId;
		this.patientId = patientId;
		this.date = date;
		this.medicine = medicine;
		this.dose = dose;
	}

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

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	@Override
	public String toString() {
		return "PrescriptionDto [prescriptionId=" + prescriptionId + ", did=" + did + ", bookingId=" + bookingId
				+ ", patientId=" + patientId + ", date=" + date + ", medicine=" + medicine + ", dose=" + dose + "]";
	}    
}
