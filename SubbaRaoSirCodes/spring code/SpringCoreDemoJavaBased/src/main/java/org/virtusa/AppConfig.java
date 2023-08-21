package org.virtusa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:applicationContext.xml")
public class AppConfig {
	@Bean
	public Product product1() {
		Product product=new Product();
		product.setPid(1);
		product.setName("Laptop");
		product.setDescription("jdfhdsfdshf");
		product.setPrice(100);
		return product;
	}
	@Bean
	public Product product2() {
		Product product=new Product();
		product.setPid(2);
		product.setName("Camera");
		product.setDescription("jdfhdsfdshf");
		product.setPrice(80);
		return product;
	}
	@Bean
	public ShoppingList shoppingList() {
		ShoppingList list=new ShoppingList();
		list.setProducts(products());
		return list;
	}
	private List<Product> products(){
		List<Product> products=new ArrayList<Product>();
		products.add(product1());
		products.add(product2());
		return products;
	}
	
}
