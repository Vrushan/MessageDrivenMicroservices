package com.example.Messagedrivenservices;



import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
@EnableBinding(Processor.class)
public class ShipmentServiceApplication {

	protected Logger logger=Logger.getLogger(ShipmentServiceApplication.class.getName());
	
	@Autowired
	private Shipmentservice shipmentservice;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ShipmentServiceApplication.class, args);
	}
	
	
	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public Order processhipment(Order order)
	{
		logger.info("The order has sent"+ order);
		
	  order.setShipment(shipmentservice.process(order));
	  
	  logger.info("The output of order"+ order);
	  
	  return order;
		
	}

}
