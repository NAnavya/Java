package org.virtusa.app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Emp {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eno;
	@NotBlank
	@Size(min=3,max=10)
	private String name;
	@NotBlank
	private String address;
	@Min(18)
	private int age;
	public Emp() {
		// TODO Auto-generated constructor stub
	}
	public Emp(int eno, String name, String address, int age) {
		super();
		this.eno = eno;
		this.name = name;
		this.address = address;
		this.age = age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	

}
