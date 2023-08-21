package com.virtusa.ibs.service;

import com.virtusa.ibs.Exception.EmptyInputException;
import com.virtusa.ibs.dto.Accounts;

public interface IAccountService
{
	public Accounts getAccountInfo(int acctID)throws EmptyInputException;
	public void deleteAccount(int acctID) throws EmptyInputException;
	public int getBalance(int acctID)throws EmptyInputException;
	public void depositAmount(int acctID, int amount)throws EmptyInputException;
	public void withdrawAmount(int acctID, int amount)throws EmptyInputException;
	public void transferAmount(int acctID, int destAcctID, int amount)throws EmptyInputException;
	public void changePasswordByAcctID(int acctID,String password)throws EmptyInputException;
	
}
