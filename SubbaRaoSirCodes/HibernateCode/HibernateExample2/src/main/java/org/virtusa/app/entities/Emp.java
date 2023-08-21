package org.virtusa.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="EMPLOYEE")
public class Emp {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eno;
	private String name;
	private String address;
	@Column(name="DATE_OF_JOIN")
	private LocalDate dateOfJoin;
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	public Emp(int eno, String name, String address, LocalDate dateOfJoin) {
		super();
		this.eno = eno;
		this.name = name;
		this.address = address;
		this.dateOfJoin = dateOfJoin;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(LocalDate dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	

}
