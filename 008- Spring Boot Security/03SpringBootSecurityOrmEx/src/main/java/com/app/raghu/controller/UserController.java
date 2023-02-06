package com.app.raghu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.raghu.entity.User;
import com.app.raghu.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService service;
	
	//1. show Register page
	@GetMapping("/register")
	public String showReg() {
		return "UserRegister";
	}
	
	//2. save user data
	@PostMapping("/save")
	public String saveUser(
			@ModelAttribute User user, Model model)
	{
		Integer id = service.saveUser(user);
		String message = "User '"+id+"' created!";
		model.addAttribute("message", message);
		return "UserRegister";
	}
	
	
}
