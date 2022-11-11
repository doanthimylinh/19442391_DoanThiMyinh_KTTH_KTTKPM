package com.example.customerservice.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customerservice.entity.Customer;
import com.example.customerservice.service.CustomerService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("")
	public Customer addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		return customer;
	}

	@DeleteMapping("/{customerId}")
	@CacheEvict(value = "customer", key = "#customerId")
	public String deleteCustomer(@PathVariable int customerId) {
		customerService.deleteCustomer(customerId);
		return "xoá thành công id" + customerId;
	}

	@PostMapping("/update")
	@CachePut(value = "users", key = "#customer.customerId")
	public Customer updateCustomer(@RequestBody Customer customer) {
		Customer customer2 = customerService.updateCustomer(customer);
		return customer2;
	}

	@GetMapping("/{customerId}")
//	@Cacheable(value = "customer", key = "#customerId")
	public Customer getCustomerById(@PathVariable int customerId) {
		Customer Customer = customerService.getCustomerById(customerId);
		return Customer;
	}

	@GetMapping("")

	public List<Customer> getListCustomer() {
		List<Customer> dsCustomer = customerService.getListCustomer();
		return dsCustomer;
	}

}
