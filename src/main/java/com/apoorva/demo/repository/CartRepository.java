package com.apoorva.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apoorva.demo.domain.Cart;
import com.apoorva.demo.domain.Category;
import com.apoorva.demo.domain.User;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	Cart findByUserEquals(User user);

}
