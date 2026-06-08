package com.pup.taguig.app.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemRequestDTO {
	
	private Long productId;
	private int quantity;
}
