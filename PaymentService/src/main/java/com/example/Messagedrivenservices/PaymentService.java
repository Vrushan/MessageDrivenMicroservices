package com.example.Messagedrivenservices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	
	List <Order> list = new ArrayList<Order>();
	public Order process(Order order)
	{
		
		Optional<Order> optional =list.stream().filter(a->a.getOrder_id().intValue()==a.getOrder_id().intValue()).findFirst();
		
		if(optional.isPresent())
		{
			Order o =optional.get();
			
			if(o.getProduct().getProd_id()!=null)
			{
				
				order.setProduct(o.getProduct());
				
			}
			else if(o.getShipment().getShipment_id()!=null)
			{
				order.setShipment(o.getShipment());
			}
			
			return order;
		}
		else 
			list.add(order);
		
		
		return null;
	}

}
