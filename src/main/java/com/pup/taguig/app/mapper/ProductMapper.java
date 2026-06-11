package com.pup.taguig.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.pup.taguig.app.model.Product;

@Mapper
public interface ProductMapper {
	
	public Long insertProduct(Product product);
	List<Product> getAllProducts(@Param("limit") int limit, @Param("offset") int offset);
	public Product getProductById(Long id);
	int updateProductStock(@Param("id") Long id, @Param("stock") Integer stock);
}
