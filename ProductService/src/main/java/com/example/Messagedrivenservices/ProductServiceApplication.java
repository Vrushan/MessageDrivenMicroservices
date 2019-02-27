package com.example.Messagedrivenservices;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding(Processor.class)
public class ProductServiceApplication {
	protected Logger logger=Logger.getLogger(ProductServiceApplication.class.getName());
	
	@Autowired
	private productService productservice;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
	
	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public Order Process(Order order)
	{
	  logger.info("The Order is processing"+ order);
	  order.setProduct(productservice.processorder(order));
	  logger.info("The Output of order is"+ order);
	  return order;
		
	}

}
