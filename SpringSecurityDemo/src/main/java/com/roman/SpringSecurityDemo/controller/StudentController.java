package com.roman.SpringSecurityDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roman.SpringSecurityDemo.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	
	List<Student> students = new ArrayList<>(List.of(
			new Student(1, "Rohit", "Python"),
			new Student(2, "Rahul", "Java")
			));
	
	@GetMapping("token")
	public CsrfToken getToken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
	
	@GetMapping("students")
	public List<Student> getStudents(){
		return students;
	}
	
	@PostMapping("student")
	public void addStudent(@RequestBody Student student) {
		students.add(student);
	}
}
