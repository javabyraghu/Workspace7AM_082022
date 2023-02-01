package com.app.raghu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.raghu.entity.Student;
import com.app.raghu.repo.StudentRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repo;

	public Mono<Student> save(Student student) {
		return repo.save(student);
	}

	public Mono<Student> getOne(String id) {
		return repo.findById(id).switchIfEmpty(Mono.empty());
	}

	public Flux<Student> findAll() {
		return repo.findAll().switchIfEmpty(Flux.empty());
	}

	public Mono<Void> delete(String id) {
		return repo.deleteById(id);
	}
}
