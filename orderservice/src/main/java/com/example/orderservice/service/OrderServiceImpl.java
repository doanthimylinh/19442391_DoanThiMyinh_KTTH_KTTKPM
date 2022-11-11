package com.example.orderservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository OrderRepository;

	@Override
	@Transactional
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return OrderRepository.save(order);
	}

	@Override
	public String deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		OrderRepository.deleteById(orderId);
		return "xoa thanh cong id" + orderId;
	}

	@Override
	public Order updateOrder(Order order) {
		Order Order2 = OrderRepository.saveAndFlush(order);
		return Order2;
	}

	@Override
	public Order getOrderById(int id) {
		Order Order = OrderRepository.findById(id).get();
		return Order;
	}

	@Override
	public List<Order> getListOrder() {
		List<Order> dsOrder = OrderRepository.findAll();
		return dsOrder;
	}
}
