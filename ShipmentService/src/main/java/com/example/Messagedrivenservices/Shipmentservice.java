package com.example.Messagedrivenservices;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Shipmentservice {
	
	List<Shipment> shipment = new ArrayList<Shipment>();
	
	Shipmentservice()
	{
		shipment.add(new Shipment(1,ShipmentType.CAR,LocalDate.now(),500));
		shipment.add(new Shipment(2,ShipmentType.PLANE,LocalDate.now(),1000));
		shipment.add(new Shipment(3,ShipmentType.SHIP,LocalDate.now(),1500));
		shipment.add(new Shipment(4,ShipmentType.TRAIN,LocalDate.now(),2000));
	}
	
	
	public Shipment process(Order order)
	{
		return shipment.stream().filter(a->a.getType().equals(order.getShipment().getType())).findAny().get();
		
	}

}
