package com.example.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.entity.Order;
import com.example.orderservice.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OrderController {

	@Autowired
	private OrderService OrderService;

	@PostMapping("")
	public Order addOrder(@RequestBody Order Order) {
		OrderService.addOrder(Order);
		return Order;
	}

	@DeleteMapping("/{orderId}")
	public String deleteOrder(@PathVariable int orderId) {
		OrderService.deleteOrder(orderId);
		return "xoá thành công id" + orderId;
	}

	@PostMapping("/update")
	public Order updateOrder(@RequestBody Order Order) {
		Order Order2 = OrderService.updateOrder(Order);
		return Order2;
	}

	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable int id) {
		Order Order = OrderService.getOrderById(id);
		return Order;
	}

	@GetMapping("")
	public List<Order> getListOrder() {
		List<Order> dsOrder = OrderService.getListOrder();
		return dsOrder;
	}
}
