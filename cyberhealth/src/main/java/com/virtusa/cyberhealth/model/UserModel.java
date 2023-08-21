package com.virtusa.cyberhealth.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.lang.NonNull;

@Entity
@Table(name="register_details")
public class UserModel {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	 int id;
	
	
	@Column(name="email")
	 String email;
	
	@Column(name="password")
	 String password;
	
	@Transient
	@Column(name="confirmpassword")
	String confirmpassword;
	
	@Column(name="mobileNumber")
	 String mobileNumber;
	
	@Column(name="username")
	 String username;
	
	@Column(name="active")
	 boolean active;
	
	@Column(name="role")
	public String role;
	
	@Column(name="Specialization")
	String specialization;
	
	
	@OneToMany
	 
	  private List<BookingModel> bookingmodel;
	
	@OneToMany(mappedBy="usermodel" ,cascade=CascadeType.ALL)
	 
	  private List<PrescriptionModel> prescriptionmodel;

	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
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
	
	

	
	
	





	private @NonNull boolean loggedIn;
	
	
	 public UserModel() {
	    }
	    public UserModel(@NonNull String username, 
	                @NonNull String password) {
	        this.username = username;
	        this.password = password;
	        this.loggedIn = false;
	    }
	    public boolean isLoggedIn() {
			return loggedIn;
		}
		public void setLoggedIn(boolean loggedIn) {
			this.loggedIn = loggedIn;
		}
		 @Override
		    public boolean equals(Object o) {
		        if (this == o) return true;
		        if (!(o instanceof UserModel)) return false;
		        UserModel user = (UserModel) o;
		        return Objects.equals(username, user.username) &&
		                Objects.equals(password, user.password);
		    }
		    @Override
		    public int hashCode() {
		        return Objects.hash(id, username, password, 
		                            loggedIn);
		    }

}