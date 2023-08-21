package com.virtusa.ibs.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.ibs.dto.Logger;
import com.virtusa.ibs.service.LoggerService;


@RestController
public class LoggerController {
	@Autowired
	private LoggerService loggerService;

	// addLog
	public void addLog(Logger logger) {
		loggerService.addLog(logger);
	}

	// showLog
	@GetMapping("/account/logs")
	public List<Logger> showLog() {
		return loggerService.showLog();
	}

	public void deleteLog(int acctID) {
		loggerService.deleteLog(acctID);
	}
}
