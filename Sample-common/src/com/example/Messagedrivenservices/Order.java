package com.example.Messagedrivenservices;

import java.time.LocalDateTime;

public class Order {
	
	private Integer order_id;
	
	private Product product;
	
	private OrderStatus status;
	
	private OrderType Type;
	
	private LocalDateTime Createdat;
	
	private Shipment shipment;
	
	
	
	public Order(Integer order_id,OrderStatus status,OrderType Type,LocalDateTime Createdat,Product product,Shipment shipment)
	{
		this.order_id=order_id;
		this.status=status;
		this.Type=Type;
		this.Createdat=Createdat;
		this.product=product;
		this.shipment=shipment;
		
	}
	public Order()
	{
		
	}
	public Integer getOrder_id() {
		return order_id;
	}
	
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public OrderStatus getStatus() {
		return status;
	}
	
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public OrderType getType() {
		return Type;
	}
	
	public void setType(OrderType type) {
		Type = type;
	}
	
	public LocalDateTime getCreatedat() {
		return Createdat;
	}
	
	public void setCreatedat(LocalDateTime createdat) {
		Createdat = createdat;
	}
	
	public Shipment getShipment() {
		return shipment;
	}
	
	public void setShipment(Shipment shipment) {
		this.shipment = shipment;
	}
	
}
