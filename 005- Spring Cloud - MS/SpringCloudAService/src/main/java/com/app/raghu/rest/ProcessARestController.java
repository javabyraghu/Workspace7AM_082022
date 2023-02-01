package com.app.raghu.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProcessARestController {
	
	private static final Logger log = LoggerFactory.getLogger(ProcessARestController.class);

	@Autowired
	private RestTemplate rt;
	
	@GetMapping("/showA")
	public String showMsg() {
		log.info("WE ARE AT A SERVICE...");
		
		String resp = rt.getForEntity("http://localhost:8082/showB", String.class).getBody();
		
		return "FROM A.."+resp;
	}
}
