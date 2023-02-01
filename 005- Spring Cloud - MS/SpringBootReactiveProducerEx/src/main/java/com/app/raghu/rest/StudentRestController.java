package com.app.raghu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.raghu.entity.Student;
import com.app.raghu.service.StudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/student")
public class StudentRestController {

	@Autowired
	private StudentService service;

	@PostMapping("/create")
	public Mono<Student> save(@RequestBody Student student) {
		return service.save(student);
	}
	
	@GetMapping("/fetch/{id}")
	public Mono<Student> getOne(@PathVariable String id) {
		return service.getOne(id);
	}
	
	@GetMapping("/all")
	public Flux<Student> fetchAll() {
		return service.findAll();
	}
	
	@DeleteMapping("/remove/{id}")
	public Mono<Void> deleteOne(@PathVariable String id) {
		return service.delete(id);
		/* service.delete(id);
		return Mono.just("Removed Id "+id); */
	}
	
}
