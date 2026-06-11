package com.pup.taguig.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pup.taguig.app.dto.ProductRequestDTO;
import com.pup.taguig.app.dto.ProductResponseDTO;
import com.pup.taguig.app.service.ProductService;

@RestController
@RequestMapping("api/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("")
	public ProductResponseDTO insertProduct(@RequestBody ProductRequestDTO product) {
		return productService.insertProduct(product);
	}
	
	@GetMapping("")
	public List<ProductResponseDTO> getAllProducts(
			@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
		
		return productService.getAllProducts(page, size);
	}
	
	@GetMapping("/{id}")
	public ProductResponseDTO getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
}
