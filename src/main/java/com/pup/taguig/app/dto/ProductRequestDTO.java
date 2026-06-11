package com.pup.taguig.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductRequestDTO {

	private String name;
	private String description;
	private Double price;
	private Integer stock;
	
}
