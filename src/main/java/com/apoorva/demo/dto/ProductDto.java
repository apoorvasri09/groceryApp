package com.apoorva.demo.dto;

import java.time.LocalDate;

import com.apoorva.demo.domain.Product;

public class ProductDto {


	private Integer id;
	

	private String name;
	private String description;
	private Integer price;
	private Integer discount;
	private Integer quantity;
	private LocalDate dateOfExpiry;
	private String vendor; //Brand
	private Integer inventoryId;
	private String categoryName;
	
	
	public static ProductDto fromProduct(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.id = product.getId();
		productDto.name = product.getName();
		productDto.description= product.getDescription();
		productDto.price = product.getPrice();
		productDto.discount = product.getDiscount();
		productDto.quantity = product.getQuantity();
		productDto.dateOfExpiry = product.getDateOfExpiry();
		productDto.vendor = product.getVendor();
		if(product.getInventory()!= null) {
			productDto.inventoryId = product.getInventory().getId();
		}
		if(product.getCategory()!= null)
			productDto.categoryName = product.getCategory().getcName();
		return productDto;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public LocalDate getDateOfExpiry() {
		return dateOfExpiry;
	}
	public void setDateOfExpiry(LocalDate dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Integer getInventoryId() {
		return inventoryId;
	}
	public void setInventoryId(Integer inventoryId) {
		this.inventoryId = inventoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
	
	
}
