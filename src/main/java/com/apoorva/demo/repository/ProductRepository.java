package com.apoorva.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.apoorva.demo.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
	 
	//search by name or category
	@Query("select product FROM Product product WHERE product.name LIKE CONCAT('%',:name,'%') OR product.category is NULL OR product.category.cName LIKE CONCAT('%',:category,'%')") 
	public List<Product> findByProductNameOrCategory(@Param("name") String name, @Param("category") String category);
    

	
}
