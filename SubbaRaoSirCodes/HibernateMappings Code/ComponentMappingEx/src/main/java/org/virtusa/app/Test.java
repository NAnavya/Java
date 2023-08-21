package org.virtusa.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.virtusa.app.config.HibConfig;
import org.virtusa.app.entities.Address;
import org.virtusa.app.entities.Emp;

public class Test {
	public static void main(String[] args) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			Address address=new Address();
			address.setDno(123);
			address.setStreetName("Gandhi Street");
			address.setLoc("Chennai");
			Emp emp=new Emp();
			emp.setEno(1);
			emp.setName("Suresh");
			emp.setAddress(address);
			session.save(emp);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		finally {
			session.close();
		}
	}
}
