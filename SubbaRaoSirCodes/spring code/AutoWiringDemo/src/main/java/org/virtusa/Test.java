package org.virtusa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.virtusa.controllers.SampleController;

public class Test {
	public static void main(String[] args) {
		//ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		SampleController controller=context.getBean("sampleController", SampleController.class);
		controller.controller();
	}
}
