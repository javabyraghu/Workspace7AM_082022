package com.app.raghu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	//EVERY ONCE CAN ACCESS
	// .antMatchers("/home").permitAll
	@GetMapping({"/home","/"})
	public String showHome() {
		return "home";
	}
	
	//ONLY AFTER LOGIN
	// .antMatchers("/hello").authenticated()
	@GetMapping("/hello")
	public String showHello() {
		return "hello";
	}
	
	//ONLY ADMIN After login
	// .antMatchers("/admin").hasAuthority("ADMIN")
	@GetMapping("/admin")
	public String showAdmin() {
		return "admin";
	}
	
	//ONLY CUSTOMER After login
	// .antMatchers("/customer").hasAuthority("CUSTOMER")
	@GetMapping("/customer")
	public String showCustomer() {
		return "customer";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
}