package com.virtusa.ibs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.virtusa.ibs.dto.Accounts;

public interface AccountsRepository extends CrudRepository<Accounts, Integer>, JpaRepository<Accounts, Integer> {
	@Query("select balance from Accounts where acctID = ?1")
	public int findBalanceByAcctID(int acctID);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Accounts set balance = balance+?2 where acctID=?1")
	public void saveBalanceByAcctID(int acctID, int balance);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Accounts set balance = balance-?2 where acctID=?1")
	public void withdrawAmountByAcctID(int acctID, int balance);
	
	
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query("update Accounts u set u.password = :password where u.acctID = :acctID")
	public void changePasswordByAcctID(int acctID,String password);
	
	@Query("select u from Accounts u where u.acctID=:p1 and u.password=:p2")
	public Accounts validateUser(@Param("p1") int acctID, @Param("p2")  String password);
}
