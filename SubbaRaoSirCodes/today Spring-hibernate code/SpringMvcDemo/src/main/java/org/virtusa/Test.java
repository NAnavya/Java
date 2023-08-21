package org.virtusa;

import java.time.LocalDate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.virtusa.config.AppConfig;
import org.virtusa.dao.EmpDao;
import org.virtusa.dao.EmpDaoImpl;
import org.virtusa.entities.Emp;

public class Test {

	public static void main(String[] args) {
		//ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		EmpDao dao=context.getBean("empDaoImpl",EmpDaoImpl.class);
		/*
		 * Emp e1=new Emp(); e1.setName("suresh"); e1.setAddress("Chennai");
		 * e1.setDateOfJoin(LocalDate.of(2010, 05, 01)); Emp e2=new Emp();
		 * e2.setName("Vamsi"); e2.setAddress("Hyd");
		 * e2.setDateOfJoin(LocalDate.of(2009, 05, 01)); dao.insert(e1); dao.insert(e2);
		 */
		dao.getAll().forEach(emp->System.out.println(emp.getEno()+"\t"+emp.getName()+"\t"+emp.getAddress()));
	}

}
