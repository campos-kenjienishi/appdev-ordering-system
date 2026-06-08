package com.pup.taguig.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.pup.taguig.app.dto.CustomerRequestDTO;
import com.pup.taguig.app.dto.CustomerResponseDTO;
import com.pup.taguig.app.mapper.CustomerMapper;
import com.pup.taguig.app.model.Customer;
import com.pup.taguig.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public CustomerResponseDTO registerCustomer(CustomerRequestDTO request) {
		
		Customer customer = new Customer();
		customer.setName(request.getName());
		customer.setEmail(request.getEmail());
		customer.setPhone(request.getPhone());
		
		customerMapper.registerCustomer(customer);
		
		CustomerResponseDTO response = new CustomerResponseDTO();
		response.setId(customer.getId());
		response.setName(customer.getName());
		response.setEmail(customer.getEmail());
		response.setPhone(customer.getPhone());
		
		return response;
		
	}

	@Override
	public CustomerResponseDTO getCustomerById(Long id) {
		Customer customer = customerMapper.getCustomerById(id);
		
		if (customer == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer with id " + id + " not found");
		}
		
		return this.toDto(customer);
	}

	private CustomerResponseDTO toDto(Customer customer) {
		return new CustomerResponseDTO(
				customer.getId(),
				customer.getName(),
				customer.getEmail(),
				customer.getPhone()
		);
	}

}
