package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.JobPosts;
import com.roman.JobApp.model.JobPost;
import com.roman.JobApp.repo.JobRepo;

@Service
public class JobService {
	
	@Autowired
	private JobRepo repo;
	
	public void addJob(JobPosts job) {
		repo.addJobPost(job); 
	}
	

	public List<JobPosts> getAllJobs() {
		return repo.returnAllJobPosts();
		
	}
}
