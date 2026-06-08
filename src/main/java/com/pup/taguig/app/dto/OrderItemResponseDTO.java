package com.pup.taguig.app.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemResponseDTO {

	private Long productId;
	private int quantity;
	private BigDecimal price;
}
