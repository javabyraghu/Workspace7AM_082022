package com.app.raghu.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.app.raghu.entity.Student;

public interface StudentRepository 
	extends ReactiveMongoRepository<Student, String>{

}
