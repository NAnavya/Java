package com.virtusa.ibs.Exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.virtusa.ibs.dto.ErrorInfo;

@ControllerAdvice
public class GeneralExceptionHandler {
	Log log=LogFactory.getLog(this.getClass());
	@ExceptionHandler(EmptyInputException.class)
	public @ResponseBody ErrorInfo EmptyInputException(EmptyInputException e,HttpServletRequest req) {
		log.error(e.getMessage());
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public @ResponseBody ErrorInfo NoSuchElementException(NoSuchElementException e,HttpServletRequest req) {
		log.error(e.getMessage());
		return new ErrorInfo(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
	}


	

}

