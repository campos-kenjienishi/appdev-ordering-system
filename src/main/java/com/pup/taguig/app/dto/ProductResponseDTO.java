package com.pup.taguig.app.dto;


import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class ProductResponseDTO {

	private Long id;
	private String name;
	private String description;
	private Double price;
	private Integer stock;
	
	private List<ProductResponseDTO> products;
	
	
}
