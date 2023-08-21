package org.virtusa.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.virtusa.app.config.HibConfig;
import org.virtusa.app.entities.FulltimeEmployee;
import org.virtusa.app.entities.ParttimeEmployee;

public class Test {

	public static void main(String[] args) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			ParttimeEmployee pt=new ParttimeEmployee();
			pt.setName("Arjun");
			pt.setAddress("Hyderabad");
			pt.setNoOfHours(20);
			pt.setSal(50000);
			session.save(pt);
			/*
			 * FulltimeEmployee fe=new FulltimeEmployee(); fe.setName("suresh");
			 * fe.setAddress("Chennai"); fe.setNoOfDays(30); fe.setSal(30000);
			 * session.save(fe);
			 */
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

}
