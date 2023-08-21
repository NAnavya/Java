package com.virtusa.ibs.service;

import java.util.List;

import com.virtusa.ibs.Exception.EmptyInputException;
import com.virtusa.ibs.Exception.NoSuchElementException;
import com.virtusa.ibs.dto.Customer;

public interface ICustomerService
{
	public void createCustomer(Customer customer);
	public Customer getCustomerInfo(int acctID) throws EmptyInputException;
	public void deleteCustomer(int acctID) throws EmptyInputException;
	public List<Customer> getCustomers() throws NoSuchElementException;
}
