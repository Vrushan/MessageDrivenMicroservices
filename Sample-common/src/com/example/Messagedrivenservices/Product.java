package com.example.Messagedrivenservices;

public class Product {
	
	private Integer prod_id;
	
	private String name;
	
	private int price;
	
	Product()
	{
		
	}
	Product(String name)
	{
		this.name=name;
	}
	
	Product(String name,int price)
	{
		this.name=name;
		this.price=price;
	}
	
	Product(Integer prod_id,String name,int price)
	{
		this.prod_id=prod_id;
		this.name=name;
		this.price=price;
	}

	public Integer getProd_id() {
		return prod_id;
	}

	public void setProd_id(Integer prod_id) {
		this.prod_id = prod_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
