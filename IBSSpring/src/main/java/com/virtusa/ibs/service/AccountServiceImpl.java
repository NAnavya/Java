package com.virtusa.ibs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.ibs.Exception.EmptyInputException;
import com.virtusa.ibs.Exception.NoSuchElementException;
import com.virtusa.ibs.Repository.AccountsRepository;
import com.virtusa.ibs.Repository.CustomerRepository;
import com.virtusa.ibs.dto.Accounts;
import com.virtusa.ibs.dto.Customer;



@Service
public class AccountServiceImpl implements IAccountService {
	@Autowired
	private AccountsRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;

	public void createAccount(Accounts acct) {
		accountRepository.save(acct);
	}

	public Accounts getAccountInfo(int acctID) 
	{
		if(acctID==0)
		{
			throw new EmptyInputException("You need to provide ID of customer to get info. ID can not be 0.");
		}
		Optional<Accounts> checkIfAccountsWithacctIDExist = accountRepository.findById(acctID);
		if (checkIfAccountsWithacctIDExist.isEmpty()) {
			throw new NoSuchElementException(
					"customer info cannot be fetched as acctID: " + acctID + " does not exist.");
		}
		
		return accountRepository.findById(acctID).orElse(null);
	}

	public void deleteAccount(int acctID) 
	{
		if(acctID==0)
		{
			throw new EmptyInputException("You need to provide ID of customer to be deleted. ID can not be 0.");
		}
		Optional<Accounts> checkIfAccountsWithacctIDExist = accountRepository.findById(acctID);
		if (checkIfAccountsWithacctIDExist.isEmpty()) {
			throw new NoSuchElementException(
					"customer can not be deleted because customer with id: " + acctID + " does not exist.");
		}
		accountRepository.deleteById(acctID);
	}

	public int getBalance(int acctID)
	{
		if (acctID==0) {
			throw new EmptyInputException("acctID not valid.");
		}
		Optional<Accounts> checkIfAccountsWithacctIDExist = accountRepository.findById(acctID);
		if (checkIfAccountsWithacctIDExist.isEmpty()) {
			throw new NoSuchElementException(
					"customer balance cant be fetched because customer with id: " + acctID + " does not exist.");
		}
		return accountRepository.findBalanceByAcctID(acctID);
	}

	public void depositAmount(int acctID, int amount) 
	{
		if (acctID==0) 
		{
			throw new EmptyInputException("acctID not valid");
		}	
		if(amount<200)
		{
		throw new NoSuchElementException("amount should be greater than 200 to deposit");
		}
		Optional<Accounts> checkIfAccountsWithacctIDExist = accountRepository.findById(acctID);
		if (checkIfAccountsWithacctIDExist.isEmpty()) {
			throw new NoSuchElementException(
					"customer with acctID: " + acctID + " does not exist.");
		}
		accountRepository.saveBalanceByAcctID(acctID, amount);
	}

	public void withdrawAmount(int acctID, int amount) 
	{
		if (acctID==0) 
		{
			throw new EmptyInputException("acctID not valid");
		}		
		Optional<Accounts> checkIfAccountsWithacctIDExist = accountRepository.findById(acctID);
		if (checkIfAccountsWithacctIDExist.isEmpty()) {
			throw new NoSuchElementException(
					"customer with acctID: " + acctID + " does not exist.");
		}
		if(amount>accountRepository.findBalanceByAcctID(acctID))
		{
		throw new NoSuchElementException("you have insufficient funds");
		}
		if(amount>10000)
		{
		throw new NoSuchElementException("Maximum Amount withdrawl is 10000");
		}
		if(amount>customerRepository.sumOfMoney())
		{
		throw new NoSuchElementException("Cannot withdraw,ATM has no cash");
		}
		
		accountRepository.withdrawAmountByAcctID(acctID, amount);
	}

	public void transferAmount(int acctID, int destAcctID, int amount) 
	{
		if (acctID==0) 
		{
			throw new EmptyInputException("acctID not valid");
		}
		if (destAcctID==0) 
		{
			throw new NoSuchElementException("destAcctID not valid");
		}
		if(acctID==destAcctID)
		{
		throw new NoSuchElementException("Cannot transfer to your own acount");
		}
		if(amount>accountRepository.findBalanceByAcctID(acctID))
		{
		throw new NoSuchElementException("you have insufficient funds to transfer your amount");
		}
		accountRepository.withdrawAmountByAcctID(acctID, amount);
		accountRepository.saveBalanceByAcctID(destAcctID, amount);
	}
	public void changePasswordByAcctID(int acctID,String password)
	{
		if (acctID==0) 
		{
			throw new EmptyInputException("acctID not valid");
		}
		Optional<Accounts> checkIfAccountsWithacctIDExist = accountRepository.findById(acctID);
		if (checkIfAccountsWithacctIDExist.isEmpty()) {
			throw new NoSuchElementException(
					"customer with acctID: " + acctID + " does not exist.");
		}
		if(password.length()>4)
		{
		throw new NoSuchElementException("password cannot be changed,It doesn't meet privacy policies of bank");
		}
	 accountRepository.changePasswordByAcctID(acctID, password);
	}
	


}
