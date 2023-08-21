package org.virtusa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		/*
		 * Emp e=context.getBean("emp",Emp.class);
		 * System.out.println(e.getEno()+"\t"+e.getName()); Address
		 * address=e.getAddress(); Company company=e.getCompany();
		 * System.out.println(address.getStreetName()+"\t"+address.getLoc());
		 * System.out.println(company.getCname()+"\t"+company.getLoc());
		 */
		ShoppingList list=context.getBean("shoppingList", ShoppingList.class);
		list.getProducts().forEach(product->{
			System.out.println(product.getName()+"\t"+product.getDescription()+"\t"+product.getPrice());
		});
	}

}
