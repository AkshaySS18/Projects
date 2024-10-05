package com.roman.SpringSecurityDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String greet(HttpServletRequest request) {
		return "Hello world"+request.getSession().getId();
		
	}
	
	@GetMapping("/about")
	public String info(HttpServletRequest request) {
		return "Messi the GOAT"+request.getSession().getId();	
	}
}
