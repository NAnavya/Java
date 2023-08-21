package com.virtusa.ibs.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.ibs.Repository.LoggerRepository;
import com.virtusa.ibs.dto.Customer;
import com.virtusa.ibs.dto.Logger;


@Service
public class LoggerService {
	@Autowired
	LoggerRepository loggerRepository;

	public void addLog(Logger logger) {
		loggerRepository.save(logger);
	}

	public List<Logger> showLog() {
		List<Logger> logger=(List<Logger>) loggerRepository.findAll();
		return (List<Logger>) loggerRepository.findAll();
	}

	public void deleteLog(int acctID) {
		loggerRepository.deleteById(acctID);
	}
}

