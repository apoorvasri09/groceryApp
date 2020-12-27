package com.apoorva.demo.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Offer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private String text;
	private String status;
	private LocalDate validfrom;
	private LocalDate validto;
	private Integer discount;
	private Integer maxPurchase;
	private Integer minPurchase;
	
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
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getValidfrom() {
		return validfrom;
	}
	public void setValidfrom(LocalDate validfrom) {
		this.validfrom = validfrom;
	}
	public LocalDate getValidto() {
		return validto;
	}
	public void setValidto(LocalDate validto) {
		this.validto = validto;
	}
	public Integer getDiscount() {
		return discount;
	}
	public void setDiscount(Integer discount) {
		this.discount = discount;
	}
	public Integer getMaxPurchase() {
		return maxPurchase;
	}
	public void setMaxPurchase(Integer maxPurchase) {
		this.maxPurchase = maxPurchase;
	}
	public Integer getMinPurchase() {
		return minPurchase;
	}
	public void setMinPurchase(Integer minPurchase) {
		this.minPurchase = minPurchase;
	}
	
	
	//add delete update & validation
//	//add list of products onetoMany
//	@OneToMany
//	private List<Product> products = new ArrayList<>();
//	

	
}
