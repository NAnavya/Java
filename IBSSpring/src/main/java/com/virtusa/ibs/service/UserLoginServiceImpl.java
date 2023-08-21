package com.virtusa.ibs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.ibs.Exception.EmptyInputException;
import com.virtusa.ibs.Repository.UserLoginRepository;

@Service
public class UserLoginServiceImpl implements IUserLoginService
{
@Autowired
UserLoginRepository userloginrepo;
public  String validate(int acctID,String password)throws EmptyInputException{
String str=userloginrepo.validate(acctID,password);
if(str!=null)
	return "User Logged in Successfully";
else
	throw new EmptyInputException( "Invalid Details of User...Please Register");
			
	}
}
