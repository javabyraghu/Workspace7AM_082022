package com.app.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//@RestController
//@RequestMapping("/users")
public class UserRestController {
	
	private static final Logger LOG = LogManager.getLogger(UserRestController.class);

	//@PostMapping("/save")
	public String saveUser() {
		LOG.info("Entered into User#save Operation ");
		try {
			LOG.warn("May not be good choice.. But valid for operation");
			//some code for save operation
			Integer id = 999;
			LOG.debug("User created with {} ",  id);
		} catch(Exception e) {
			LOG.error("Unable to process details {}", e.getMessage());
			e.printStackTrace();
			throw e;
		}
		LOG.info("About to Leave Save Operation");
		return "SUCCESS";
	}
}
