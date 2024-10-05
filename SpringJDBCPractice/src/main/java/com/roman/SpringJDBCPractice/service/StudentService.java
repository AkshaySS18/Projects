package com.roman.SpringJDBCPractice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roman.SpringJDBCPractice.model.Student;
import com.roman.SpringJDBCPractice.repo.StudentRepo;

@Service
public class StudentService {
	
	private StudentRepo repo; 

	public StudentRepo getRepo() {
		return repo;
	}

	@Autowired
	public void setRepo(StudentRepo repo) {
		this.repo = repo;
	}

	public void addStudent(Student s) {
		repo.save(s);		
	}

	public List<Student> getAllStudents() {
		return repo.findAll();
	}
	
}
