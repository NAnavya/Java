package org.virtusa.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.virtusa.app.config.HibConfig;
import org.virtusa.app.entities.Course;
import org.virtusa.app.entities.Student;

public class Test1 {

	public static void main(String[] args) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Student st=new Student();
		st.setName("ram");
		st.setAddress("Chennai");
		Course c1=new Course();
		c1.setCourseName("java");
		c1.setFee(200);
		c1.setStudent(st);
		Course c2=new Course();
		c2.setCourseName("java");
		c2.setFee(200);
		c2.setStudent(st);
		st.addCourse(c1);
		st.addCourse(c2);
		session.save(st);
		tx.commit();
		session.close();
		
	}

}
