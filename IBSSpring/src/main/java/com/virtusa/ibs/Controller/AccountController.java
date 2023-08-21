package com.virtusa.ibs.Controller;




import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.ibs.Repository.AccountsRepository;
import com.virtusa.ibs.dto.Accounts;
import com.virtusa.ibs.dto.Logger;
import com.virtusa.ibs.service.AccountServiceImpl;
import com.virtusa.ibs.service.CustomerServiceImpl;


@RestController
@RequestMapping("/User")
public class AccountController {
	@Autowired
	private AccountServiceImpl accountServiceImpl;
	@Autowired
	private LoggerController loggerController;

	Log log=LogFactory.getLog(AccountController.class);
	
	// createAccount happens upon createCustomer
		public void createAccount(int acctID, int balance, String acctStatus,String password) {
			Accounts acct = new Accounts(acctID, balance, acctStatus,password);
			accountServiceImpl.createAccount(acct);
			log.info("Account created");
		}

	// checkBalance
	@GetMapping("/account/{acctID}/balance")
	public int getBalance(@PathVariable int acctID){
		log.info("choosen to fetch the balance");
		return accountServiceImpl.getBalance(acctID);
	}

	// depositAmount
	@PutMapping("/account/{acctID}/deposit/{amount}")
	public String depositAmount(@PathVariable int acctID, @PathVariable int amount) {
		int initBal = getBalance(acctID);
		accountServiceImpl.depositAmount(acctID, amount);
		Logger logger = new Logger(0,acctID, "Deposited", "Success", initBal, initBal + amount);
		loggerController.addLog(logger);
		log.info("choosen to deposit the amount");
		return "Amount"+amount+" has deposited successfully,updated balance is"+getBalance(acctID)+"";
	}

	// withdrawAmount
	@PutMapping("/account/{acctID}/withdraw/{amount}")
	public String withdrawAmount(@PathVariable int acctID, @PathVariable int amount) {
		int initBal = getBalance(acctID);
		accountServiceImpl.withdrawAmount(acctID, amount);
		Logger logger = new Logger(0,acctID, "Withdrawn", "Success", initBal, initBal - amount);
		loggerController.addLog(logger);
		log.info("choosen withdraw option");
		return "Ammount"+amount+"is withdrawn successfully,updated balance is"+getBalance(acctID)+"";
	}

	// transferAmount
	@PutMapping("/account/{acctID}/transfer/{destAcctID}/{amount}")
	public String transferAmount(@PathVariable int acctID, @PathVariable int destAcctID, @PathVariable int amount) {
		int initBalSender = getBalance(acctID);
		int initBalReceiver = getBalance(destAcctID);
		accountServiceImpl.transferAmount(acctID, destAcctID, amount);
		Logger loggerSender = new Logger(0,acctID, "Transferred", "Success", initBalSender, initBalSender - amount);
		loggerController.addLog(loggerSender);
		Logger loggerReceiver = new Logger(0,destAcctID, "Received", "Success", initBalReceiver,
				initBalReceiver + amount);
		loggerController.addLog(loggerReceiver);
		log.info("choosen transfer option for transfering the money");
		return "Amount"+amount+"has transfered successfully,,updated balance is"+getBalance(acctID)+""; 
	}

	// deleteAccount
	@DeleteMapping("/account/{acctID}")
	public void deleteAccount(@PathVariable int acctID) {
		accountServiceImpl.deleteAccount(acctID);
		log.info("choosen delete option to delete the account info");
	}
	//changePassword
	@PutMapping("account/{acctID}/changePassword/{password}")
	public String changePassword(@PathVariable int acctID,@PathVariable String password)
	{
	accountServiceImpl.changePasswordByAcctID(acctID, password);
	return "Your password is changed successfully";
	}
	// getAccountInfo
	@GetMapping("/account/{acctID}")
	public Accounts getAccountInfo(@PathVariable int acctID) {
		log.info("choosen accountinfo to fetch own details");
		return accountServiceImpl.getAccountInfo(acctID);
	}

}

