package com.apoorva.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apoorva.demo.domain.Cart;
import com.apoorva.demo.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartRepository cartRepository;
	
	@Override
	public void saveCart(Cart cart) {
		cartRepository.save(cart);
	}
}
