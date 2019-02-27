package com.example.Messagedrivenservices;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.acks.AcknowledgmentCallback.Status;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.retry.policy.AlwaysRetryPolicy;


import com.example.Messagedrivenservices.Order;

@EnableBinding(Source.class)
@SpringBootApplication
public class OrderServiceApplication {

	private static final Logger logger=Logger.getLogger(OrderServiceApplication.class.getName());
	private int index=0;
	public static void main(String[] args) {
         SpringApplication.run(OrderServiceApplication.class, args);
		
		
	}
	
	@Bean
	@InboundChannelAdapter(value=Source.OUTPUT,poller=@Poller(fixedDelay="10000",maxMessagesPerPoll="1"))
	public MessageSource<Order> orderprocess()
	{
		return()->
		{
			Order order=new Order(index++,OrderStatus.New,OrderType.Purchase,LocalDateTime.now(),new Product("Example#1"),new Shipment(ShipmentType.CAR));
			logger.info("Sending order"+ order );
			return new GenericMessage<Order>(order);
		};
		
	}
	

}
