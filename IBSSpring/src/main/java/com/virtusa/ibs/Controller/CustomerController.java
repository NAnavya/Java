package com.virtusa.ibs.Controller;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.ibs.Repository.CustomerRepository;

import com.virtusa.ibs.dto.Customer;
import com.virtusa.ibs.dto.Logger;
import com.virtusa.ibs.service.CustomerServiceImpl;
import com.virtusa.ibs.service.ICustomerService;



@RestController
@RequestMapping("/Admin")
public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	@Autowired
	private AccountController accountController;
	@Autowired
	private LoggerController loggerController;
	Log log=LogFactory.getLog(CustomerController.class);

	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		customerServiceImpl.createCustomer(customer);
		accountController.createAccount(customer.getAcctID(), 0, "Active",customer.getPassword());
		log.info("Choosen to create Customer");
		return customer;
	}
	@GetMapping("/customer/{acctID}")
	public Customer getCustomerInfo(@PathVariable int acctID) {
		log.info("choosen to get customer information");
		 return customerServiceImpl.getCustomerInfo(acctID);
		
	}

	@DeleteMapping("/customer/{acctID}")
	public String deleteCustomer(@PathVariable int acctID) {
		customerServiceImpl.deleteCustomer(acctID);
		accountController.deleteAccount(acctID);
		log.info("choosen to delete the customer from the database");
		return "Account deleted successfully";
	}
	@GetMapping("/customerall")
	public List<Customer> getCustomers()
	{
	log.info("choosen to fetch the list of customers");
	return customerServiceImpl.getCustomers();
	}
	@GetMapping("/sum")
	public String sumofMoney()
	{
	int x=customerServiceImpl.sumOfMoney();
	return"Total money deposited,"+x;
	}
	@GetMapping("/showTransactions")
	public List<Logger> showTransactions()
	{
	return loggerController.showLog();
	}
	
}
