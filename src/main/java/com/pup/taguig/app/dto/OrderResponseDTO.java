package com.pup.taguig.app.dto;

import java.math.BigDecimal;
import java.util.List;

import com.pup.taguig.app.model.OrderItem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDTO {
	private Long id;
	private Long customerId;
	private String status;
	private BigDecimal totalPrice;
	
	private List<OrderItem> items;
}
