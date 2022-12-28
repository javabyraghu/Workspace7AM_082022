package com.app.raghu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.raghu.entity.Role;
import com.app.raghu.entity.User;
import com.app.raghu.repo.RoleRepository;
import com.app.raghu.repo.UserRepository;

@Component
public class TestDataInsertRunner implements CommandLineRunner {

	@Autowired
	private RoleRepository rrepo;
	
	@Autowired
	private UserRepository repo;
	
	public void run(String... args) throws Exception {
		Role r1 = new Role(503, "ADMIN");
		Role r2 = new Role(504, "GUEST");
		
		rrepo.save(r1);
		rrepo.save(r2);
		
		User u1 = new User(10, "SYED", r1);
		User u2 = new User(11, "SAM", r2);
		
		repo.save(u1);
		repo.save(u2);
		
	}

}
