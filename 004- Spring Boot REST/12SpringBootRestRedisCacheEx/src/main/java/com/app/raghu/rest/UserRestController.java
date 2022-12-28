package com.app.raghu.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.raghu.entity.User;
import com.app.raghu.service.UserService;

@RestController
@RequestMapping("/v1/api/users")
public class UserRestController {

	@Autowired
	private UserService service;
	
	@PostMapping("/create")
	public String createUser(@RequestBody User user) {
		Integer id = service.saveUser(user);
		return "User '"+id+"' created!";
	}
	
	@GetMapping("/find/{id}")
	public User findOneUser(@PathVariable Integer id) {
		return service.getOneUser(id);
	}
	
	@DeleteMapping("/remove/{id}")
	public String deleteUser(@PathVariable Integer id) {
		service.deleteUser(id);
		return "User Deleted!";
	}
	
	@PutMapping("/modify")
	public String updateUser(@RequestBody User user) {
		service.updateUser(user.getId(), user);
		return "User Updated!";
	}
	
	
}
