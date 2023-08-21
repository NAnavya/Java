package org.virtusa.app;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		Configuration configuration=new Configuration();
		configuration.configure("hibernate.cfg.xml");
		SessionFactory factory=configuration.buildSessionFactory();
		Session session=factory.openSession();
		Emp e1=new Emp();
		e1.setEno(1);
		e1.setName("suresh");
		e1.setAddress("Chennai");
		e1.setDateOfJoin(LocalDate.now());
		Integer i=(Integer)session.save(e1);
		//session.flush();
		System.out.println("The employee with "+i+" is inserted successfully");
		session.close();
		
	}

}
