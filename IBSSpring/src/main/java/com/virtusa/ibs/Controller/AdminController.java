package com.virtusa.ibs.Controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.ibs.Exception.NoSuchElementException;
import com.virtusa.ibs.Repository.AccountsRepository;
import com.virtusa.ibs.Repository.AdminRepository;
import com.virtusa.ibs.dto.Admin;
import com.virtusa.ibs.service.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController 
{
@Autowired
AdminServiceImpl adminServiceImpl;

Log log=LogFactory.getLog(AdminRepository.class);
@PostMapping("/createAccount")
public Admin createAccount()
{
String email="Venkat@gmail.com";
String password="Venkata@123";
String username="Venkat";
Admin admin=new Admin(email,password,username);
adminServiceImpl.createAccount(admin);
return admin;
}
@GetMapping("/login/email/{email}/password/{password}")
public String login(@PathVariable String email,@PathVariable String password) throws NoSuchElementException {
	String str=adminServiceImpl.validate(email,password);
	if(str!=null)
		log.info("admin login successfully");
	return str;
}
}
