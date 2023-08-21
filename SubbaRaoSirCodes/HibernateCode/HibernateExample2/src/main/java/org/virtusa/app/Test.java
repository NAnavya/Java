package org.virtusa.app;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.virtusa.app.config.HibConfig;
import org.virtusa.app.entities.Emp;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Emp e=new Emp();
		e.setName("suresh");
		e.setAddress("Chennai");
		e.setDateOfJoin(LocalDate.now());
		Transaction transaction=session.beginTransaction();
		session.persist(e);
		transaction.commit();
		//session.flush();
		session.close();
	}

}
