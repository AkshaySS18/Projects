package com.roman.SpringSecurityDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roman.SpringSecurityDemo.model.User;
import com.roman.SpringSecurityDemo.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("register")
	public User register(@RequestBody User user) {
		return service.saveUser(user);
	}
}
