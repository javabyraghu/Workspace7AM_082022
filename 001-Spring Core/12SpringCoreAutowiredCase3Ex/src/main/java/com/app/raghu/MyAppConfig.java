package com.app.raghu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("com.app.raghu")
public class MyAppConfig {

	//1 method = 1 object
	@Bean
	@Primary
	public MyRepository m1() {
		MyRepository m1 = new MyRepository();
		m1.setCode("A");
		return m1;
	}
	
	@Bean
	public MyRepository m2() {
		MyRepository m2 = new MyRepository();
		m2.setCode("B");
		return m2;
	}
}
