package com.app.raghu.entity;

import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@JsonProperty("user-unq-id")
	private Integer userId;
	
	@JsonProperty("user-first-name")
	private String userName;
	
	private String userRole;
	
	@JsonIgnore
	private String password;
	
	private Set<String> permissions; 
	//private List<String> permissions; 
	//private String[] permissions; 
	
	private Map<String,String> models;
	//private Properties models;
	
	
}
