package org.virtusa;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext3.xml");
		Academy academy=context.getBean("academy",Academy.class);
		System.out.println(academy.getName());
		System.out.println("The courses are");
		List<Course> courses=academy.getCourses();
		courses.forEach(course->System.out.println(course.getCourseName()+"\t"+course.getPrice()));
	}

}
