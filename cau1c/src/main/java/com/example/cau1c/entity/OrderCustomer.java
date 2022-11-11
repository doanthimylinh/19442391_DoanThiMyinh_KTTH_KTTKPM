package com.example.cau1c.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor

@ToString
public class OrderCustomer {
	private int orderId;

	private String name;

	private double price;

	private Customer customerId;

	public OrderCustomer(int orderId, String name, double price, Customer customerId) {
		super();
		this.orderId = orderId;
		this.name = name;
		this.price = price;
		this.customerId = customerId;
	}

}
