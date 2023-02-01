package com.app.raghu.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProcessCRestController {
	
	private static final Logger log = LoggerFactory.getLogger(ProcessCRestController.class);

	@GetMapping("/showC")
	public String showMsg() {
		log.info("WE ARE AT C SERVICE...");
		//some logic...
		log.info("WE ARE LEAVING FROM SERVICE C...");
		
		return "FROM C..";
	}
}
