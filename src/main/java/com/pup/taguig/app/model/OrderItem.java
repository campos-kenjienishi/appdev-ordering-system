package com.pup.taguig.app.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
	
	private Long id;
	private Long orderId;
	private Long productId;
	private int quantity;
	private BigDecimal price;
}
