package com.app.raghu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class SpringCloudMqConsumerExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudMqConsumerExApplication.class, args);
	}

}
