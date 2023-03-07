package com.app.raghu.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserRestController {
	
	//private static final Logger log = LogManager.getLogger(UserRestController.class);

	@PostMapping("/save")
	public String saveUser() {
		log.info("Entered into User#save Operation ");
		try {
			log.warn("May not be good choice.. But valid for operation");
			//some code for save operation
			Integer id = 999;
			log.debug("User created with {} ",  id);
		} catch(Exception e) {
			log.error("Unable to process details {}", e.getMessage());
			e.printStackTrace();
			throw e;
		}
		log.info("About to Leave Save Operation");
		return "SUCCESS";
	}
}