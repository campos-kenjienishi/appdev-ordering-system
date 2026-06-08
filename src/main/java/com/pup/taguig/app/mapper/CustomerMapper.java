package com.pup.taguig.app.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.pup.taguig.app.model.Customer;

@Mapper
public interface CustomerMapper {
	
	public Long registerCustomer(Customer request);
	
}
