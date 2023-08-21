package org.virtusa.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Passport {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String passportNumber;
	private String nationality;
	@OneToOne(mappedBy="passport")
	private Student student;
	public Passport() {
		// TODO Auto-generated constructor stub
	}
	public Passport(int id, String passportNumber, String nationality) {
		super();
		this.id = id;
		this.passportNumber = passportNumber;
		this.nationality = nationality;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	
}
