package com.virtusa.cyberhealth.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.virtusa.cyberhealth.model.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Integer>{
	
	
	
	public boolean existsByEmail(String email);
	
	List<UserModel>findByRole(String role);
	
	 UserModel findByEmail(String email);
	 
		@Query( value="select * from cyberhealth.register_details b where b.mobile_number =?1",nativeQuery = true)
	 UserModel findByMobileNumber(String mobileNumber);
	 

		@Query( value="select * from cyberhealth.booking_details b where b.doctor_id =?1",nativeQuery = true)
	 List<UserModel>findByDocId(int id);

	UserModel findByEmailAndPassword(String email, String password);
	

}