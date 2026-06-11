package com.pup.taguig.app.service;

import java.util.List;

import com.pup.taguig.app.dto.ProductRequestDTO;
import com.pup.taguig.app.dto.ProductResponseDTO;

public interface ProductService {
	
	public ProductResponseDTO insertProduct(ProductRequestDTO product);
	List<ProductResponseDTO>getAllProducts(int page, int size);
	public ProductResponseDTO getProductById(Long id);
	
}
