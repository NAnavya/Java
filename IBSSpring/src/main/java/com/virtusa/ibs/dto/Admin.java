package com.virtusa.ibs.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admins")
public class Admin 
{
@Id
String email;
String password;
String username;
public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
public Admin(String email, String password, String username) {
	super();
	this.email = email;
	this.password = password;
	this.username = username;
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
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
@Override
public String toString() {
	return "Admin [email=" + email + ", password=" + password + ", username=" + username + "]";
}

}
