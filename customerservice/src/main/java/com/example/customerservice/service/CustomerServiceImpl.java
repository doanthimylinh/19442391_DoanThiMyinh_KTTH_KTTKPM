package com.example.customerservice.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customerservice.entity.Customer;
import com.example.customerservice.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@Transactional
	public Customer addCustomer(Customer Customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(Customer);
	}

	@Override
	public String deleteCustomer(int CustomerId) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(CustomerId);
		return "xoa thanh cong id" + CustomerId;
	}

	@Override
	public Customer updateCustomer(Customer Customer) {
		Customer Customer2 = customerRepository.saveAndFlush(Customer);
		return Customer2;
	}

	@Override
	public Customer getCustomerById(int id) {
		Customer Customer = customerRepository.findById(id).get();
		return Customer;
	}

	@Override
	public List<Customer> getListCustomer() {
		List<Customer> dsCustomer = customerRepository.findAll();
		return dsCustomer;
	}
}
