package com.example.Messagedrivenservices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class productService {
	List<Product> products = new ArrayList<>();
	public productService()
	{
		
		
		products.add(new Product(1,"Example#1",500));
		products.add(new Product(2,"Example#2",1000));
		products.add(new Product(3,"Example#3",1500));
		products.add(new Product(4,"Example#4",2000));
		
		
	}
	
	public Product processorder(Order order)
	{
		return products.stream().filter(a->a.getName().equals(order.getProduct().getName())).findAny().get();
		
	}
	

}
