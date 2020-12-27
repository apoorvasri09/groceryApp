package com.apoorva.demo.domain;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Product implements Serializable{

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", discount=" + discount + ", quantity=" + quantity + ", dateOfExpiry=" + dateOfExpiry + ", vendor="
				+ vendor + ", inventory=" + inventory + ", category=" + category + ", getQuantity()=" + getQuantity()
				+ ", getVendor()=" + getVendor() + ", getInventory()=" + getInventory() + ", getId()=" + getId()
				+ ", getDescription()=" + getDescription() + ", getPrice()=" + getPrice() + ", getDiscount()="
				+ getDiscount() + ", getDateOfExpiry()=" + getDateOfExpiry() + ", getCategory()=" + getCategory()
				+ ", getName()=" + getName() + ", isNewProduct()=" + isNewProduct() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public Product() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String description;
	
	private Integer price;
	private Integer discount;
	private Integer quantity;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfExpiry;

	private String vendor; //Brand
	
	
	//product inventory for quantity and discount;
	@OneToOne
	private ProductInventory inventory;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	
	//setter getters
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	
	public ProductInventory getInventory() {
		return inventory;
	}

	public void setInventory(ProductInventory inventory) {
		this.inventory = inventory;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	

	public LocalDate getDateOfExpiry() {
		return dateOfExpiry;
	}

	public void setDateOfExpiry(LocalDate dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//checking for new id or not
	public boolean isNewProduct() {
        return (this.id == null);
    }
	
	

}
