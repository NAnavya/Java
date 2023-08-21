package com.virtusa.ibs.service;

import com.virtusa.ibs.Exception.EmptyInputException;

public interface IUserLoginService 
{
	public  String validate(int acctID,String password)throws EmptyInputException;
}
