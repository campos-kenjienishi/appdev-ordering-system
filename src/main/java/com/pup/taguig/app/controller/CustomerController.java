package com.pup.taguig.app.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pup.taguig.app.dto.CustomerRequestDTO;
import com.pup.taguig.app.dto.CustomerResponseDTO;
import com.pup.taguig.app.service.CustomerService;

@RestController
@RequestMapping("api/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("")
	public CustomerResponseDTO registerCustomer(@RequestBody CustomerRequestDTO customer) {
		if (Objects.nonNull(customer)) {
			return customerService.registerCustomer(customer);
		}
		
		return null;
	}
}
