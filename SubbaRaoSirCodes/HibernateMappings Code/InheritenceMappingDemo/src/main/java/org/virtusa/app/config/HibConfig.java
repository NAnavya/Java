package org.virtusa.app.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.virtusa.app.entities.Employee;
import org.virtusa.app.entities.FulltimeEmployee;
import org.virtusa.app.entities.ParttimeEmployee;

public class HibConfig {
	public static SessionFactory getSessionFactory() {
		Configuration configuration=new Configuration();
		configuration.setProperties(hibernateProperties());
		configuration.addAnnotatedClass(Employee.class);
		configuration.addAnnotatedClass(FulltimeEmployee.class);
		configuration.addAnnotatedClass(ParttimeEmployee.class);
		return configuration.buildSessionFactory();
		
	}
	private static Properties hibernateProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		properties.put("hibernate.connection.url", "jdbc:mysql://localhost:3306/test");
		properties.put("hibernate.connection.username", "root");
		properties.put("hibernate.connection.password", "root");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		properties.put("hibernate.show_sql", true);
		properties.put("hibernate.format_sql", true);
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;
	}
}
