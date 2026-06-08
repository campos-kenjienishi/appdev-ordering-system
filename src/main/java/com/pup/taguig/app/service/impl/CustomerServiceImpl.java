package com.pup.taguig.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pup.taguig.app.dto.CustomerRequestDTO;
import com.pup.taguig.app.mapper.CustomerMapper;
import com.pup.taguig.app.model.Customer;
import com.pup.taguig.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public Long registerCustomer(CustomerRequestDTO request) {
		
		Customer customer = new Customer();
		customer.setName(request.getName());
		customer.setEmail(request.getEmail());
		customer.setPhone(request.getPhone());
		
		customerMapper.registerCustomer(customer);
		Long id = customer.getId();
		
		return id;
		
	}

}
