package org.virtusa.aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SampleDemoLoggingAspect {
	
	@Pointcut("execution(* org.virtusa.aop.dao.*.*(..))")
	private void forDaoPackage() {
		
	}
	//create a point cut for getter methods
	@Pointcut("execution(* org.virtusa.aop.dao.*.get*(..))")
	private void getter() {
		
	}
	@Pointcut("execution(* org.virtusa.aop.dao.*.set*(..))")
	private void setter() {
		
	}
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageExceptGetterAndSetters() {
		
	}
	@Before("forDaoPackageExceptGetterAndSetters()")
	public void beforeInsertEmployee() {
		System.out.println("Before advice");
	}
	
	
	/*
	 * //matching insert method with any parameter
	 * 
	 * @Before("execution(* insert*(..))") public void beforeInsertingEmployee() {
	 * System.out.println("Executed before advice on method"); }
	 */
}
