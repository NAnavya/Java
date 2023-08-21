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
@Table(name = "booking_details")
public class BookingModel {

	@Id
	@Column(name = "bookingId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int bookingId;

	public BookingModel() {
		super();
	}

	@Column(name = "date")
	@JsonFormat(pattern = "yyyy/MM/dd")
	Date date;

	public BookingModel(int bookingId, Date date, UserModel patientId, UserModel usermodel, String time,
			Boolean bookingStatus) {
		super();
		this.bookingId = bookingId;
		this.date = date;
		this.patientId = patientId;
		this.usermodel = usermodel;
		this.time = time;
		this.bookingStatus = bookingStatus;
	}
	@ManyToOne
	@JoinColumn(name = "patientId")
	UserModel patientId;
	
	@ManyToOne
	 @JoinColumn(name="DoctorId")
	UserModel usermodel;

//	public int getPatientId() {
//		return patientId;
//	}

	public UserModel getUsermodel() {
		return usermodel;
	}

	public UserModel getPatientId() {
		return patientId;
	}

	public void setPatientId(UserModel patientId) {
		this.patientId = patientId;
	}

	public void setUsermodel(UserModel usermodel) {
		this.usermodel = usermodel;
	}
//
//	public void setPatientId(int patientId) {
//		this.patientId = patientId;
//	}

	@Column(name = "time")
	String time;

	@Column(name = "bookingStatus")
	Boolean bookingStatus;



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
		return "BookingModel [bookingId=" + bookingId + ", date=" + date + ", patientId=" + patientId + ", usermodel="
				+ usermodel + ", time=" + time + ", bookingStatus=" + bookingStatus + "]";
	}
	

}
