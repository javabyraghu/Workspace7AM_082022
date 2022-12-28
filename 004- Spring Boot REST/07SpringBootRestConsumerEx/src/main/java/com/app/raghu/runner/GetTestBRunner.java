package com.app.raghu.runner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.app.raghu.entity.BookAtConsumer;

@Component
public class GetTestBRunner implements CommandLineRunner {

	public void run(String... args) throws Exception {
		String url = "http://localhost:8080/v1/api/book/showC";
		RestTemplate template = new RestTemplate();
		
		//ResponseEntity<BookAtConsumer> response = template.getForEntity(url, BookAtConsumer.class); 
		ResponseEntity<BookAtConsumer> response = template.exchange(url, HttpMethod.GET, null, BookAtConsumer.class); 
		

		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
		System.out.println(response.getStatusCode().name());
		System.out.println(response.getStatusCode().value());
		
	}

}
