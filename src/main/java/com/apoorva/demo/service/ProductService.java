package com.apoorva.demo.service;

import java.util.List;
import java.util.Optional;

import com.apoorva.demo.domain.Product;
import com.apoorva.demo.dto.ProductDto;

public interface ProductService {
	
	public List<ProductDto> findAllProducts();
	public Product saveProduct(Product product);
	public Optional<Product> findProductById(Integer productId);
	public void deleteProductById(Integer productId);
	public List<ProductDto> searchByProductNameOrCategory(String keyword);
}
