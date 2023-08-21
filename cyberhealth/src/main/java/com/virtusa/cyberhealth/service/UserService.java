package com.virtusa.cyberhealth.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.virtusa.cyberhealth.dto.UserDto;
import com.virtusa.cyberhealth.model.UserModel;
import com.virtusa.cyberhealth.repo.UserRepo;

@Service
public class UserService {

	
	@Autowired
	UserRepo userdao;
	public UserModel saveuser(UserModel user) {
		return userdao.save(user);
	}
	public UserModel checkUser(String email,String password) {
		return userdao.findByEmailAndPassword(email, password);
	}
	public UserModel adduser(UserDto user) {
		// TODO Auto-generated method stub
		UserModel userModel=new UserModel();
		userModel.setEmail(user.getEmail());
		userModel.setPassword(user.getPassword());
		userModel.setConfirmpassword(user.getConfirmpassword());
		userModel.setMobileNumber(user.getMobileNumber());
		userModel.setRole(user.getRole());
		userModel.setUsername(user.getUsername());
		userModel.setActive(user.getActive());
		userModel.setSpecialization(user.getSpecialization());
		userModel.setLoggedIn(user.isLoggedIn());
		return null;
	}
	
	
	
	
	}