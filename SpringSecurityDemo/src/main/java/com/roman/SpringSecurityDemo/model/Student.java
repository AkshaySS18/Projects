package com.roman.SpringSecurityDemo.model;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private int id;
	private String name;
	private String techStack;
	
	public Student() {
		super();
	}

	public Student(int id, String name, String techStack) {
		super();
		this.id = id;
		this.name = name;
		this.techStack = techStack;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTechStack() {
		return techStack;
	}

	public void setTechStack(String techStack) {
		this.techStack = techStack;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", techStack=" + techStack + "]";
	}
	
	
}
