package com.ecommerce.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.entity.Product;


//✅ findByCategory(String category) 
//	→ Custom method to retrieve products by category. 
//✅ No need to write SQL queries! Spring Boot translates this into SQL automatically.


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // Find all products by category
    List<Product> findByCategory(String category);
}
