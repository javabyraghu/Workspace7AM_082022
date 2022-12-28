package com.app.raghu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.raghu.entity.Product;
import com.app.raghu.repo.ProductRepository;

@Component
public final class TestDataRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository repo;
	
	public void run(String... args) throws Exception {
		repo.save(new Product(101, "AA", 200.0));
		System.out.println("___________________________");
		int count = repo.updateNameById("PEN", 101);
		System.out.println(count);
		
		
		int count2 = repo.removeById(101);
		System.out.println(count2);
		
	}

}
