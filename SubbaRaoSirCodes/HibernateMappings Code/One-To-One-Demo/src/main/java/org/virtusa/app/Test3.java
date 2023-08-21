package org.virtusa.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.virtusa.app.config.HibConfig;
import org.virtusa.app.entities.Role;
import org.virtusa.app.entities.User;

public class Test3 {

	public static void main(String[] args) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			User user1=new User();
			user1.setUsername("suresh");
			user1.setPassword("suresh@123");
			user1.setEmail("suresh@gmail.com");
			User user2=new User();
			user2.setUsername("naresh");
			user2.setPassword("naresh@123");
			user2.setEmail("naresh@gmail.com");
			
			Role role1=new Role();
			role1.setRoleName("MANAGER");
			Role role2=new Role();
			role2.setRoleName("HR");
			
			user1.addRole(role1);
			user1.addRole(role2);
			user2.addRole(role1);
			role1.addUser(user1);
			role1.addUser(user2);
			role2.addUser(user1);
			
			session.save(user1);
			session.save(user2);
			session.save(role1);
			session.save(role2);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}

}
