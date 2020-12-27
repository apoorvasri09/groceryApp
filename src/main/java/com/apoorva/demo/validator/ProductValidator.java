package com.apoorva.demo.validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.apoorva.demo.domain.Product;
import com.apoorva.demo.service.ProductService;

@Component
public class ProductValidator implements Validator{

	@Autowired
    ProductService productService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty.addproductform.name");
	}

	
}
