package com.roman.JobApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roman.JobApp.model.JobPost;
import com.roman.JobApp.repo.JobRepo;

@Service
public class JobService {
	
	@Autowired
	private JobRepo repo;
	
	public void addJob(JobPost job) {
		repo.save(job); 
	}

	public List<JobPost> getAllJobs() {
		return repo.findAll();
		
	}
}
	
	
