package com.app.raghu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.raghu.entity.Book;
import com.app.raghu.repo.BookRepository;

@RestController
@RequestMapping("/book")
public class BookRestController {

	@Autowired
	private BookRepository repo;
	
	@PostMapping("/create")
	public String createBook(@RequestBody Book book) {
		repo.save(book);
		return "BOOK CREATED";
	}
}
