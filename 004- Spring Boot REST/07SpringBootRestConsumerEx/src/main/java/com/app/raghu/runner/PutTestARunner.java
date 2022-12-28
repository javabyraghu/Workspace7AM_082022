package com.app.raghu.runner;


import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//@Component
public class PutTestARunner implements CommandLineRunner {

	public void run(String... args) throws Exception {
		String url = "http://localhost:8080/v1/api/book/showE";
		
		String body = "{\"bid\" : 101,\"bname\" : \"ABC\", \"bauth\":\"AJ\", \"bcost\":500.0}";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
		
		RestTemplate rt = new RestTemplate();
		//This method makes request , but returns no body (void)
		//rt.put(url, requestEntity);
		ResponseEntity<String> response = rt.exchange(url, HttpMethod.PUT, requestEntity, String.class);
		
		System.out.println(response.getBody());
		System.out.println(response.getHeaders());
		System.out.println(response.getStatusCode().name());
		System.out.println(response.getStatusCode().value());
		
	}

}
