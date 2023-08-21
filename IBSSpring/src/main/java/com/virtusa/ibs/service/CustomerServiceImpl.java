package com.virtusa.ibs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import com.virtusa.ibs.Exception.EmptyInputException;
import com.virtusa.ibs.Exception.NoSuchElementException;
import com.virtusa.ibs.Repository.CustomerRepository;
import com.virtusa.ibs.dto.Customer;
import com.virtusa.ibs.dto.Logger;



@Service
public class CustomerServiceImpl implements ICustomerService
{
	@Autowired
	private CustomerRepository customerRepository;

	public void createCustomer(Customer customer) 
	{
		customerRepository.save(customer);
	}

	public Customer getCustomerInfo(int acctID) {
		return customerRepository.findById(acctID).orElseThrow(() -> new NoSuchElementException("Customer with id: " + acctID + " does not exist."));
	}

	public void deleteCustomer(int acctID) {
		if(acctID==0)
		{
			throw new EmptyInputException("You need to provide ID of customer to be deleted. ID can not be 0.");
		}
		Optional<Customer> checkIfCustomerWithacctIDExist = customerRepository.findById(acctID);
		if (checkIfCustomerWithacctIDExist.isEmpty()) {
			throw new NoSuchElementException(
					"customer can not be deleted because customer with id: " + acctID + " does not exist.");
		}
		customerRepository.deleteById(acctID);
	}
	public List<Customer> getCustomers()
	{
		List<Customer> customer = customerRepository.findAll();
		if (customer.isEmpty()) {
			throw new NoSuchElementException("No Data Is Found");
		}
	return customerRepository.findAll();
	}
	public int sumOfMoney()
	{
	return customerRepository.sumOfMoney();
	}
	
}

