package com.app.service;

import org.springframework.beans.factory.annotation.Value;

//@Component
public class MyService {

	@Value("SAMPLE DATA")
	private String code;

	@Override
	public String toString() {
		return "MyService [code=" + code + "]";
	}
	
	
}
