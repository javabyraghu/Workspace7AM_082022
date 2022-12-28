package com.app.raghu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import com.app.raghu.repo.EmployeeRepository;

//@Component
public class TestCFetchDataRunner implements CommandLineRunner {

	@Autowired
	private EmployeeRepository repo;
	
	public void run(String... args) throws Exception {
		//1. select * from employee order by esal ASC
		//use static method by() present in Sort class.
		repo.findAll(Sort.by("empSal"))
		.forEach(System.out::println);;
		
		//2. select * from employee order by esal DESC
		// Use Direction property in by() method.
		//repo.findAll(Sort.by(Direction.ASC,"empSal"))
		repo.findAll(Sort.by(Direction.DESC,"empSal"))
		.forEach(System.out::println);
		
		//3. select * from employee order by esal, dept ; //both ASC
		//3. select * from employee order by esal DESC, dept DESC; //both DESC
		//repo.findAll(Sort.by("empSal","empDept"))
		repo.findAll(Sort.by(Direction.DESC,"empSal","empDept"))
		.forEach(System.out::println);
		
		//4. select * from employee order by esal ASC, dept DESC;
		repo.findAll(Sort.by(Order.asc("empSal"),Order.desc("empDept")))
		.forEach(System.out::println);
		
		
	}

}
