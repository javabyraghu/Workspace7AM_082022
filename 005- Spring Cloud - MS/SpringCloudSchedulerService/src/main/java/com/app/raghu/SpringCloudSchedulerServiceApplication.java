package com.app.raghu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringCloudSchedulerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudSchedulerServiceApplication.class, args);
	}

}
