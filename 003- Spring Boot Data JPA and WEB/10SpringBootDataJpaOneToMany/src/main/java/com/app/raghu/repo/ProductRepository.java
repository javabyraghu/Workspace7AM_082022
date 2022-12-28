package com.app.raghu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.raghu.entity.Product;

public interface ProductRepository 
	extends JpaRepository<Product, Integer> {

}
