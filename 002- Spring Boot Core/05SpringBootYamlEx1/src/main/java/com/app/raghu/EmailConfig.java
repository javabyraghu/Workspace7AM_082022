package com.app.raghu;

import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ConfigurationProperties("my.app")
@Component
@Setter
@Getter
@ToString
public class EmailConfig {

	private String host;
	private int port;
	private String username;
	private String pasword;
	
	private Set<String> protocols;
	private Map<String,String> headers;
	
	private Certificate cob;
	
}
