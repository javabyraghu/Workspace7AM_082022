package com.app.raghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"/home","/"})
	public String showHome() {
		return "home";
	}
	
	@GetMapping("/hello")
	public String showHello() {
		return "hello";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
}