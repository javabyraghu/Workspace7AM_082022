package com.app.raghu.service;

import org.springframework.stereotype.Service;

import com.app.raghu.entity.Product;
import com.app.raghu.exception.ProductNotFoundException;

@Service
public class ProductService {

	public Product getOneProductById(Integer id) {
		if(id==150)
			return new Product(id, "DUMMY");
		else 
			throw new ProductNotFoundException("PRODUCT '"+id+"' NOT EXIST");
	}

}
