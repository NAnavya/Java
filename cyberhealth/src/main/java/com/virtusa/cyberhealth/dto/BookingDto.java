package com.virtusa.cyberhealth.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class BookingDto {
	int bookingId;
	@JsonFormat(pattern = "yyyy/MM/dd")
	Date date;
    int patientId;
    int docterId;
    String time;
    Boolean bookingStatus;
	public BookingDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookingDto(int bookingId, Date date, int patientId, int docterId, String time, Boolean bookingStatus) {
		super();
		this.bookingId = bookingId;
		this.date = date;
		this.patientId = patientId;
		this.docterId = docterId;
		this.time = time;
		this.bookingStatus = bookingStatus;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDocterId() {
		return docterId;
	}
	public void setDocterId(int docterId) {
		this.docterId = docterId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Boolean getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(Boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	@Override
	public String toString() {
		return "BookingDto [bookingId=" + bookingId + ", date=" + date + ", patientId=" + patientId + ", docterId="
				+ docterId + ", time=" + time + ", bookingStatus=" + bookingStatus + "]";
	}
	
    
}
