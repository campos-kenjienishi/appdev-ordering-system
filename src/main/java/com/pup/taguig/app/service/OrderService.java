package com.pup.taguig.app.service;

import java.util.List;

import com.pup.taguig.app.dto.OrderRequestDTO;
import com.pup.taguig.app.dto.OrderResponseDTO;

public interface OrderService {

	public OrderResponseDTO createOrder(OrderRequestDTO request);
	public OrderResponseDTO getOrderById(Long id);
	public List<OrderResponseDTO> getCustomerOrders(Long id);
	public boolean cancelOrder(Long id);
}
