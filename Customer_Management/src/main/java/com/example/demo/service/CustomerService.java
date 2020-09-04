package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.Exception.*;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	public void addCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();

	}

	public Optional<Customer> getCustomer(Integer id) {
		return customerRepository.findById(id);

	}

	public boolean removeCustomer(Integer id) {
		Optional<Customer> cust=customerRepository.findById(id);
		if(cust!=null) {
			customerRepository.deleteById(cust.get().getCustomer_id());
			return true;
		}
		else {
			return false;
		}

	}
	
	
	public void updateCustomer(Customer customer)
	{
		Customer cust=customerRepository.findById(customer.getCustomer_id()).orElseThrow(() -> new NotFoundException("customer not found with customerId : " + customer.getCustomer_id()));
		cust.setCustomer_id(customer.getCustomer_id());
		cust.setSsn_id(customer.getSsn_id());
		cust.setAddress(customer.getAddress());
		cust.setCustomer_name(customer.getCustomer_name());
		cust.setAge(customer.getAge());
		cust.setCity(customer.getCity());
		cust.setState(customer.getState());
		customerRepository.save(cust);	
	}

}
