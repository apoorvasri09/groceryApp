package com.apoorva.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apoorva.demo.domain.Product;
import com.apoorva.demo.dto.ProductDto;
import com.apoorva.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	public List<ProductDto> findAllProducts() {
		List<Product> productList = productRepository.findAll();
		List<ProductDto> productDtoList = new ArrayList<>();
		for(Product product: productList ) {
			productDtoList.add(ProductDto.fromProduct(product));
		}
		return productDtoList;
	}
	
	//save product
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	//find by productId
	public Optional<Product> findProductById(Integer productId) {
		return productRepository.findById(productId);
	}
	
	//delete product by id
	public void deleteProductById(Integer productId) {
		productRepository.deleteById(productId);
	}

	@Override//search by product name or category
	public List<ProductDto> searchByProductNameOrCategory(String keyword) {
		List<Product> productList = productRepository.findByProductNameOrCategory(keyword, keyword);
		List<ProductDto> productDtoList = new ArrayList<>();
		for(Product product: productList ) {
			productDtoList.add(ProductDto.fromProduct(product));
		}
		return productDtoList;
	}
	
}
