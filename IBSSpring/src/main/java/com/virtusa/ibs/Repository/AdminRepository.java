package com.virtusa.ibs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.virtusa.ibs.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin, String>
{
	@Query("select a.email from Admin a where a.email=:email and a.password=:password")
	public String validate(@Param("email")String email,@Param("password")String password);
}
