package com.app.raghu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServerExApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerExApplication.class, args);
	}

}
