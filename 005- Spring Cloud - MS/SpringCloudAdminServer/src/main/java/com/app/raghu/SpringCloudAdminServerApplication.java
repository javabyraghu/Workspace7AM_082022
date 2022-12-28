package com.app.raghu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class SpringCloudAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAdminServerApplication.class, args);
	}

}
