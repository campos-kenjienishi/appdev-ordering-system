package com.pup.taguig.app.dto;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ProductResponseDTO {
@Getter
@Setter
@NoArgsConstructor
	
	private String name;
	private String description;
	private float price;
	private int stock;
	
	private List<ProductResponse> products;
	
}
