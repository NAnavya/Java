package com.virtusa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.virtusa.ibs.Repository.AccountsRepository;
import com.virtusa.ibs.Repository.CustomerRepository;
import com.virtusa.ibs.dto.Customer;

@SpringBootTest
class IbsSpringApplicationTests {

	@Autowired
	CustomerRepository customerRepo;
	@Autowired
	AccountsRepository accountsRepo;
	
	

	
	@Test
	public void testReadAll()
	{
		
		List<Customer> customer=customerRepo.findAll();
		assertThat(customer);
	}
	
	
	@Test
	public void testdelete()
	{
	customerRepo.deleteById(48195734);
	accountsRepo.deleteById(48195734);
	assertThat(customerRepo.existsById(48195734)).isFalse();
	
	}
}
