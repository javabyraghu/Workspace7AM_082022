package com.app.raghu.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.app.raghu.entity.Employee;
import com.app.raghu.repo.EmployeeRepository;

@Component
public class TestDFetchPagRunner implements CommandLineRunner {
	
	@Autowired
	private EmployeeRepository repo;
	
	public void run(String... args) throws Exception {
		//repo.findAll().forEach(System.out::println);
		
		//inpput
		Pageable p = PageRequest.of(44, 4);
		
		//output
		Page<Employee> page = repo.findAll(p);
		
		//result
		page.getContent()//List<T>
		.forEach(System.out::println);
		
		//metadata
		System.out.println(page.isFirst());
		System.out.println(page.isLast());
		System.out.println(page.isEmpty());
		System.out.println(page.hasNext());
		System.out.println(page.hasPrevious());
		System.out.println(page.getTotalPages());
		System.out.println(page.getTotalElements());
		System.out.println(page.getSize());
		System.out.println(page.hasContent());
	}

}
