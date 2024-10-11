package com.roman.SpringBootWeb4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControllers {
	
	@RequestMapping("")
	public String home() {
		System.out.println("Home method called");
		return "index";
	}
	
	@RequestMapping("add")
	public String add(int num1, int num2, Model model) {
		int result = num1 + num2;
		model.addAttribute("result",result);
		return "result";
	}
	
	@RequestMapping("addAlien")
	public String addAlien(Alien alien) {
		
		
		return "result";
	}
}
