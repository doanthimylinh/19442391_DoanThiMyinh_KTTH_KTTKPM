package com.example.customerservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.customerservice.entity.Customer;

@Service
public interface CustomerService {

	public Customer addCustomer(Customer customer);

	public String deleteCustomer(int customerId);

	public Customer updateCustomer(Customer customer);

	public Customer getCustomerById(int id);

	public List<Customer> getListCustomer();
}
