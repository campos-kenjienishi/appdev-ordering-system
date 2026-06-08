package com.pup.taguig.app.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pup.taguig.app.dto.OrderRequestDTO;
import com.pup.taguig.app.dto.OrderResponseDTO;
import com.pup.taguig.app.service.OrderService;

@RestController
@RequestMapping("api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("")
	public OrderResponseDTO createOrder(@RequestBody OrderRequestDTO order) {
		if (Objects.nonNull(order)) {
			return orderService.createOrder(order);
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public OrderResponseDTO getOrderById(Long id) {
		if (Objects.nonNull(id)) {
			return orderService.getOrderById(id);
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public boolean cancelOrder(Long id) {
		if (Objects.nonNull(id)) {
			return orderService.cancelOrder(id);
		}
		return false;
	}
}
