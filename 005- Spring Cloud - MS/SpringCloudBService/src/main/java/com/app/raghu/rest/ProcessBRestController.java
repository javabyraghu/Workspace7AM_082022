package com.app.raghu.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProcessBRestController {
	
	private static final Logger log = LoggerFactory.getLogger(ProcessBRestController.class);

	@Autowired
	private RestTemplate rt;
	
	@GetMapping("/showB")
	public String showMsg() {
		log.info("WE ARE AT B SERVICE...");
		
		String resp = rt.getForEntity("http://localhost:8083/showC", String.class).getBody();
		
		return "FROM B.."+resp;
	}
}
