package com.app.raghu.rest;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/secure")
	public String showHome(Principal p) 
	{
		System.out.println(p);
		return "Secure";
	}
	
	@GetMapping("/")
	public String showLogin() 
	{
		return "Index";
	}
}
