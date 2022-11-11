package com.example.cau1c.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.cau1c.entity.Customer;
import com.example.cau1c.entity.Order;
import com.example.cau1c.entity.OrderCustomer;


@RestController
@RequestMapping("/api")
public class OrderAPIController {
	String urlOrder = "http://localhost:8081/order";
	String urlCustomer = "http://localhost:8083/customer";

	@GetMapping("/order/{orderId}")
	public OrderCustomer getOrder(@PathVariable String orderId) {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Order> response = restTemplate.getForEntity(urlOrder + "/" + orderId, Order.class);
		
		ResponseEntity<Customer> responseCustomer = restTemplate
				.getForEntity(urlCustomer + "/" + response.getBody().getCustomerId(), Customer.class);
		
		OrderCustomer orderCustomer = new OrderCustomer(response.getBody().getOrderId(), response.getBody().getName(),
				response.getBody().getPrice(), responseCustomer.getBody());
		return orderCustomer;
	}

	@GetMapping("/customer/{customerId}")
	public Customer getOrder123(@PathVariable String customerId) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Customer> response = restTemplate.getForEntity(urlCustomer + "/" + customerId, Customer.class);

		return response.getBody();
	}

}
