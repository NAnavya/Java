package com.virtusa.ibs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.virtusa.ibs.dto.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>
{
@Query(value = "SELECT SUM(balance) FROM Accounts", nativeQuery = true)
public int sumOfMoney();


}
