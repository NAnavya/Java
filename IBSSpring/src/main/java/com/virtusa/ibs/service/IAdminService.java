package com.virtusa.ibs.service;

import com.virtusa.ibs.Exception.EmptyInputException;
import com.virtusa.ibs.Exception.NoSuchElementException;
import com.virtusa.ibs.dto.Admin;

public interface IAdminService 
{
	public void createAccount(Admin admin);
	public  String validate(String email,String password)throws NoSuchElementException;
}
