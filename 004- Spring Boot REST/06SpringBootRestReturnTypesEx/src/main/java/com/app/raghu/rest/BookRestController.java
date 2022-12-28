package com.app.raghu.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.raghu.entity.Book;

@RestController
@RequestMapping("/book")
public class BookRestController {
	
	//Path variable id --> Book (200,book,found=yes), String(400,Sorry No Book found, found=no)
	@GetMapping("/obj/{id}")
	public ResponseEntity<?> findBookById(@PathVariable Integer id) 
	{
		ResponseEntity<?> response = null;
		HttpHeaders headers = new HttpHeaders();
		
	
		if(id == 501) {
			headers.add("found", "yes");
			
			response = new ResponseEntity<Book>(
					new Book(id, "DUMMY", 500.0),   //body 
					headers,  //headers
					HttpStatus.OK); //http status
		} else {
			
			headers.add("found", "no");
			response = new ResponseEntity<String>(
					"Sorry! No Book Found",   //body 
					headers,  //headers
					HttpStatus.BAD_REQUEST); //http status
		}
		
		return response;
	}
	
	
	@GetMapping("/a")
	public String justBody() {
		return "Hello Book Data!";
	}
	
	@GetMapping("/b")
	public Book justBook() {
		return new Book(10,"AA",200.0);
	}

	@GetMapping("/data")
	public ResponseEntity<String> showInfo() {
		//1. passing Http Status
		//ResponseEntity<String> response = new ResponseEntity<>(HttpStatus.OK);
		
		//2. passing Body + Http Status
		//String body = "WELCOME TO APP";
		//ResponseEntity<String> response = new ResponseEntity<>(body, HttpStatus.OK);
		
		//3. Passing  headers + status
		HttpHeaders headers = new HttpHeaders();
		headers.add("MyAppOne", "ACTIVATED-CLIENT");
		//ResponseEntity<String> response = new ResponseEntity<>(headers, HttpStatus.OK);
		
		//4. Passing body + headers + status
		String body = "WELCOME TO APP";
		ResponseEntity<String> response = 
				new ResponseEntity<>(body, headers, HttpStatus.OK);
		
		return response;
	}
}
