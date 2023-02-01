package com.app.raghu.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.app.raghu.entity.Student;

import reactor.core.publisher.Mono;

@Component
public class TestProducerCallRunner implements CommandLineRunner {

	public void run(String... args) throws Exception {
		//1. Create WebClient object using base URL 
		WebClient client = WebClient.create("http://localhost:9090/student");
		
		//call 
		/*
		Mono<Student> result = 
				client
				.post() //Http Method
				.uri("/create") //PATH
				.body(Mono.just(new Student("AA256", "SAM", 300.0)), Student.class) //Body
				.retrieve() // execute
				.bodyToMono(Student.class); //convert response
		
		System.out.println("FROM CONSUMER ---->");
		//access result
		result.subscribe(System.out::println);
		*/
		
		
		/*
		Flux<Student> flux =  client.get().uri("/all").retrieve().bodyToFlux(Student.class);
		flux.doOnNext(System.out::println).blockLast();
		*/
		
		Mono<Student> result = 
		client.get().uri("/fetch/AA256").retrieve() 
		.bodyToMono(Student.class);
		result.subscribe(System.out::println);
	}

}
