package com.app.raghu.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.raghu.entity.Book;
import com.app.raghu.repo.BookRepository;

@Component
public class TestDataRunner implements CommandLineRunner {
	@Autowired
	private BookRepository repo;
	
	public void run(String... args) throws Exception {
		repo.saveAll(
				Arrays.asList(
						new Book(101, "SBMS", "RAGHU", 300.0, "Backend"),
						new Book(102, "CORE", "RAGHU", 200.0, "Backend"),
						new Book(103, "ADV", "ASHOK", 400.0, "Backend"),
						new Book(104, "REACT", null, 500.0, "Frontend"),
						new Book(105, "HTML", "RAGHU", 600.0, "Frontend"),
						new Book(106, "CSS", null, 300.0, "Frontend"),
						new Book(107, "ANGULAR", "ASHOK", 800.0, "Frontend"),
						new Book(108, "SQL", "RAGHU", 200.0, "Database")
						)
				);
		
		repo.getBooksByAuthor("RAGHU").forEach(System.out::println);
		//repo.getBooksAuthorCost("r%", 200.0).forEach(System.out::println);
		//repo.getBooksIds(Arrays.asList(101,106,108,111,134)).forEach(System.out::println);
		
		
	}

}
