package com.pup.taguig.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pup.taguig.app.dto.ProductRequestDTO;
import com.pup.taguig.app.dto.ProductResponseDTO;
import com.pup.taguig.app.mapper.ProductMapper;

import com.pup.taguig.app.model.Product;
import com.pup.taguig.app.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductMapper productMapper;
	
	public ProductResponseDTO insertProduct(ProductRequestDTO request) {
		if (request.getPrice() == null || request.getPrice() <= 0) {
            throw new IllegalArgumentException("Price must be greater than 0");
        }
        if (request.getStock() == null || request.getStock() < 0) {
            throw new IllegalArgumentException("Stock must be greater than or equal to 0");
        }
        
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        
        productMapper.insertProduct(product);
        
        ProductResponseDTO response = new ProductResponseDTO();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setStock(product.getStock());
        
        return response;
	}
	

	@Override
	public List<ProductResponseDTO> getAllProducts(int page, int size) {
		int offset = (page - 1) * size;
        
        List<Product> products = productMapper.getAllProducts(size, offset);
        List<ProductResponseDTO> productList = new ArrayList<>();
        
        for (Product p : products) {
            ProductResponseDTO dto = new ProductResponseDTO();
            dto.setId(p.getId());
            dto.setName(p.getName());
            dto.setDescription(p.getDescription());
            dto.setPrice(p.getPrice());
            dto.setStock(p.getStock());
            productList.add(dto);
        }
        
        return productList;
    }

	@Override
	public ProductResponseDTO getProductById(Long id) {
		Product product = productMapper.getProductById(id);
		
		if (product == null) {
			return null;
	}

		ProductResponseDTO dto = new ProductResponseDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setStock(product.getStock());
        
        return dto;
	}

}
