package com.app.raghu.runner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import com.app.raghu.entity.Student;
import com.app.raghu.repo.StudentRepository;

@Component
public class StudentTestRunner implements CommandLineRunner {

	@Autowired
	private StudentRepository repo;
	
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yy");
		String s = sdf.format(new Date());
		System.out.println(s);
		
		Student s1 = new Student();
		s1.setStdName("SAM");
		s1.setStdFee(400.0);
		s1.setStdDoj(new Date());
		repo.save(s1);
		
		List<Student> list = repo.findAll();
		System.out.println(list.getClass().getName());
		list.forEach(System.out::println);
		
		Student sob = new Student();
		sob.setStdFee(400.0);
		sob.setStdName("AJAY");
		Example<Student> prob = Example.of(sob);
		repo.findAll(prob).forEach(System.out::println);
	}

}
