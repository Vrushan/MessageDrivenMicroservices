package com.example.Messagedrivenservices;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@SpringBootApplication
@EnableBinding(Sink.class)
public class PaymentServiceApplication {

	  Logger logger=Logger.getLogger(PaymentServiceApplication.class.getName());
	
	@Autowired
	
	private PaymentService paymentService;
	
	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}
	
	@StreamListener(Sink.INPUT)
	public void process(Order order)
	{
		logger.info("processing order"+ order);
		Order o =paymentService.process(order);
		if(o!=null)
		logger.info("The Final response"+o.getProduct().getPrice()+" "+ o.getShipment().getPrice());
		
	}

}
