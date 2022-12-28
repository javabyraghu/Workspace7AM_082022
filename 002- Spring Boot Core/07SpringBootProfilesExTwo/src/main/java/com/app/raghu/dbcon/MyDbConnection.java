package com.app.raghu.dbcon;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
@ConfigurationProperties("my.db")
public class MyDbConnection {

	private String driver;
	private String url;
	private String user;
	private String pwd;
	
}
