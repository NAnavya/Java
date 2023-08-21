package org.virtusa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
		Emp e=context.getBean("emp", Emp.class);
		Address address=e.getAddress();
		Company company=e.getCompany();
		System.out.println(e.getEno()+"\t"+e.getName());
		System.out.println(address.getDno()+"\t"+address.getStreetName()+"\t"+address.getLoc());
		System.out.println(company.getCid()+"\t"+company.getCompanyName()+"\t"+company.getCompanyLoc());
	}

}
