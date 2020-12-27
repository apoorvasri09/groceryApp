package com.apoorva.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apoorva.demo.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
