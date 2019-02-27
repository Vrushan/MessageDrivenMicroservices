package com.example.Messagedrivenservices;

import java.time.LocalDate;

public class Shipment {
	
	private Integer shipment_id;
	
	private ShipmentType type;
	
	private LocalDate date;
	
	private int price;
	
	Shipment()
	{
		
	}
	
	Shipment(ShipmentType type)
	{
		super();
		this.type=type;
	}
	
	Shipment(Integer shipment_id,ShipmentType type,LocalDate date,int price)
	{
		this.shipment_id=shipment_id;
		this.type=type;
		this.date=date;
		this.price=price;
	}

	public Integer getShipment_id() {
		return shipment_id;
	}

	public void setShipment_id(Integer shipment_id) {
		this.shipment_id = shipment_id;
	}

	public ShipmentType getType() {
		return type;
	}

	public void setType(ShipmentType type) {
		this.type = type;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
