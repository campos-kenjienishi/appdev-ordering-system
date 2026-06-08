package com.pup.taguig.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pup.taguig.app.dto.OrderRequestDTO;
import com.pup.taguig.app.dto.OrderResponseDTO;
import com.pup.taguig.app.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public OrderResponseDTO createOrder(OrderRequestDTO request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderResponseDTO getOrderById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderResponseDTO> getCustomerOrders(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cancelOrder(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
