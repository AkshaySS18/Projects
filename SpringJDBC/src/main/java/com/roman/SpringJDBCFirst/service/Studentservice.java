package com.roman.SpringJDBCFirst.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roman.SpringJDBCFirst.model.Student;
import com.roman.SpringJDBCFirst.repo.Studentrepo;

@Service
public class Studentservice {

	private Studentrepo repo;
	
	public Studentrepo getRepo() {
		return repo;
	}

	@Autowired
	public void setRepo(Studentrepo repo) {
		this.repo = repo;
	}

	
	
	public void addStudent(Student s) {
		
		repo.save(s);
	}

	public List<Student> getStudents() {
	
		return repo.findAll();
	}
	
	

}