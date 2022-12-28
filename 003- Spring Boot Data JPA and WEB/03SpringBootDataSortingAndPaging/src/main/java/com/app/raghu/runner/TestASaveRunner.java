package com.app.raghu.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.app.raghu.entity.Employee;
import com.app.raghu.repo.EmployeeRepository;

@Component
@Order(10)
public class TestASaveRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;
	
	public void run(String... args) throws Exception {
		
		repo.saveAll(
				//List.of(
				Arrays.asList(
						new Employee(10, "AAB", 200.0, "DEV"),
						new Employee(11, "AAB", 200.0, "QA"),
						new Employee(12, "AAB", 200.0, "BA"),
						new Employee(13, "AAB", 300.0, "DEV"),
						new Employee(14, "AAB", 300.0, "QA"),
						new Employee(15, "AAB", 300.0, "BA"),
						new Employee(16, "AAB", 400.0, "DEV"),
						new Employee(17, "AAB", 400.0, "QA"),
						new Employee(18, "AAB", 400.0, "BA")
						)
				);
		
		
		
	}
}
