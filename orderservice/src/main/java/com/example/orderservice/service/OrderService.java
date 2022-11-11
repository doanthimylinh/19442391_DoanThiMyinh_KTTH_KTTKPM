package com.example.orderservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.orderservice.entity.Order;

@Service
public interface OrderService {

	public Order addOrder(Order order);

	public String deleteOrder(int orderId);

	public Order updateOrder(Order order);

	public Order getOrderById(int id);

	public List<Order> getListOrder();
}
