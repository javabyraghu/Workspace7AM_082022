package com.app.raghu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CheckObjRunner implements CommandLineRunner {

	@Autowired
	private EmailConfig em;
	
	public void run(String... args) throws Exception {
		System.out.println(em);
	}

}
