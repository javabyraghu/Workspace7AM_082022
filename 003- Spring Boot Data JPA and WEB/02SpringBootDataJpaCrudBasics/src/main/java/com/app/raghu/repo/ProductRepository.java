package com.app.raghu.repo;

import org.springframework.data.repository.CrudRepository;

import com.app.raghu.entity.Product;

public interface ProductRepository 
	extends CrudRepository<Product, Integer>{

}
