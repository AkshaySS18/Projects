package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.JobService;

@Controller
public class JobRestController {
	
	@Autowired
	public JobService service;
	
	@GetMapping("jobPosts")
	public List<JobPosts> getAllJobs() {
		return service.getAllJobs();
	}
}
