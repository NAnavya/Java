package org.virtusa;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext4.xml");
		Quiz quiz=context.getBean("quiz", Quiz.class);
		System.out.println("The question is ");
		System.out.println(quiz.getQuestion());
		System.out.println("The answers are");
		Map<String, User> answers=quiz.getAnswers();
		answers.entrySet().forEach((Map.Entry<String,User> entry)->{
			System.out.println(entry.getKey());
			System.out.println("The answer given by");
			User user=entry.getValue();
			System.out.println(user.getName());
		});
	}

}
