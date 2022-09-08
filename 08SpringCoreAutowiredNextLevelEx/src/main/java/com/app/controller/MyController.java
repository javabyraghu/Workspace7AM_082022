package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.service.MyService;

@Component
public class MyController {
	//@Autowired
	@Autowired(required = false)
	private MyService service; //HAS-A

	@Override
	public String toString() {
		return "MyController [service=" + service + "]";
	}
	
	
}
