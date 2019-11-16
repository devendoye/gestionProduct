package com.commerce.microservice.Dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.microservice.model.Product;

public interface ProductDao  extends JpaRepository<Product, Integer> {
	
	Product findById(int id);
	
	


	
}
