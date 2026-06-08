package com.pup.taguig.app.service;

import com.pup.taguig.app.dto.CustomerRequestDTO;

public interface CustomerService {

	public Long registerCustomer(CustomerRequestDTO request);
	
}