package com.virtusa.ibs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.ibs.Exception.NoSuchElementException;
import com.virtusa.ibs.Repository.AdminRepository;
import com.virtusa.ibs.dto.Admin;

@Service
public class AdminServiceImpl implements IAdminService
{
@Autowired
AdminRepository adminRepository;
public void createAccount(Admin admin)
{
adminRepository.save(admin);
}
public  String validate(String email,String password)throws NoSuchElementException{
	String str=adminRepository.validate(email,password);
	if(str!=null)
	   return "Admin Logged in Successfully";
	else
		throw new NoSuchElementException( "Invalid Details of Admin");
		
}
}
