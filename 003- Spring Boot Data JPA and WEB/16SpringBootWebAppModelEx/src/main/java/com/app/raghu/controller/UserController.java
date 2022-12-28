package com.app.raghu.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.raghu.bean.User;

@Controller
public class UserController {
	// Path /info , Method: GET
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String showUserPage(
			//Model model
			//ModelMap model
			Map<String,Object> model
			) 
	{
		System.out.println(model.getClass().getName());
		
		//model.addAttribute("uname", "AJAY RAJ");
		//model.addAttribute("cname", "SBMS");
		
		model.put("uname", "AJ");
		model.put("cname", "SBCDE");
		return "UserHome";
	}
	
	
	//Sending one User Object
	@RequestMapping(value = "/obj",method = RequestMethod.GET)
	public String showUserOb(Model model) {
		User user = new User(10,"AJAY RAJ!","TAG-SY");
		model.addAttribute("obj",user);
		
		
		List<User> list = Arrays.asList(
				new User(10,"AA","XYZ"),
				new User(11,"AB","XYZ"),
				new User(12,"AC","MNO"),
				new User(13,"AD","MNO")
				);
		model.addAttribute("listObj", list);
		
		return "UserData";
	}
	
	
}
