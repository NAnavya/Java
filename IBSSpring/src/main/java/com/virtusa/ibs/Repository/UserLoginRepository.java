package com.virtusa.ibs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virtusa.ibs.dto.Customer;

public interface UserLoginRepository extends JpaRepository<Customer, Integer>{
	@Query("select u.acctID from Customer u where u.acctID=:acctID and u.password=:password")
	public String validate(@Param("acctID")int acctID,@Param("password")String password);

}
