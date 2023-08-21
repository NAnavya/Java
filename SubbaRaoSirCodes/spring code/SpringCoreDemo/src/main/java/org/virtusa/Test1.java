package org.virtusa;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext2.xml");
		College college=context.getBean("college",College.class);
		System.out.println(college.getCid()+"\t"+college.getCollegeName());
		System.out.println("The courses are");
		List<String> courses=college.getCourses();
		courses.forEach(System.out::println);
	}

}
