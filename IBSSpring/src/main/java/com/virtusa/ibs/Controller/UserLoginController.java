package com.virtusa.ibs.Controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.ibs.Exception.EmptyInputException;
import com.virtusa.ibs.Repository.UserLoginRepository;
import com.virtusa.ibs.service.UserLoginServiceImpl;
@RestController
@RequestMapping("/UserLogin")
public class UserLoginController
{
	@Autowired
	UserLoginServiceImpl userloginservice;
	Log log=LogFactory.getLog(UserLoginRepository.class);
	@GetMapping("/acctID/{acctID}/password/{password}")
	public String login(@PathVariable int acctID,@PathVariable String password) throws EmptyInputException{
		String str=userloginservice.validate(acctID,password);
		if(str!=null)
			log.info("User login successfully");
		return str;
	}
	
}
