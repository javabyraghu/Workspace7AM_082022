package com.app.raghu.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//@Component
public class GetTestARunner2 implements CommandLineRunner {

	public void run(String... args) throws Exception {
		//1. Create URL
		String url = "http://localhost:8080/v1/api/book/showB/{id}/{name}";
		
		//2. Create Request Headers
		//3. Create Request Body
		
		// 2+3

		//4. Create RestTemplate object
		RestTemplate template = new RestTemplate();
		
		//5. Make HTTP call and Get Response back
		ResponseEntity<String> response = 
				//template.getForEntity(url,String.class,101, "ABC" ); 
		template.exchange(url, HttpMethod.GET, null, String.class, 101,"ABC"); 
		
		//6. print details
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
		System.out.println(response.getStatusCode().name());
		System.out.println(response.getStatusCode().value());
		
	}

}
