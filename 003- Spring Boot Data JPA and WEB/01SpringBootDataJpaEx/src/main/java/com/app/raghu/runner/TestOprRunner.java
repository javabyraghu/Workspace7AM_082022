package com.app.raghu.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.raghu.entity.Student;
import com.app.raghu.repo.StudentRepository;

@Component
public class TestOprRunner implements CommandLineRunner {

	@Autowired
	private StudentRepository repo;
	
	public void run(String... args) throws Exception {
		System.out.println(repo.getClass().getName());
		
		Student sob = new Student();
		sob.setStdId(99);
		sob.setStdName("SAM");
		sob.setStdFee(20000.0);
		
		repo.save(sob); // INSERT OR UPDATE
		
	}

}
