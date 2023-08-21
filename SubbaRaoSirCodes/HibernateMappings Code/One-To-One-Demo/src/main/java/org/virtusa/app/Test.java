package org.virtusa.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.virtusa.app.config.HibConfig;
import org.virtusa.app.entities.Passport;
import org.virtusa.app.entities.Student;

public class Test {

	public static void main(String[] args) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		/*
		 * Transaction tx=null; try { tx=session.beginTransaction(); Student st=new
		 * Student(); st.setName("Ramesh"); st.setAddress("Hyd"); Passport passport=new
		 * Passport(); passport.setPassportNumber("08978343443");
		 * passport.setNationality("Indian"); st.setPassport(passport);
		 * session.save(st); tx.commit(); } catch (Exception e) { tx.rollback(); }
		 * finally { session.close(); }
		 */
		/*Student student=session.get(Student.class, 1);
		Passport passport=student.getPassport();
		System.out.println(student.getName()+"\t"+student.getAddress());
		System.out.println(passport.getPassportNumber()+"\t"+passport.getNationality());*/
		Passport passport=session.get(Passport.class, 1);
		Student st=passport.getStudent();
		System.out.println(st.getName()+"\t"+st.getAddress());
		System.out.println(passport.getPassportNumber()+"\t"+passport.getNationality());
		
	}

}
