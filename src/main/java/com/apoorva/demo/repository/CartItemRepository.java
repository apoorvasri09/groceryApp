package com.apoorva.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apoorva.demo.domain.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer>{

}
