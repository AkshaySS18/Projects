package com.roman.SpringJDBCPractice.model;

import org.springframework.stereotype.Component;

@Component
public class Student {
	private String name;
	private int marks;
	private int rollNo;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getMarks() {
		return marks;
	}
	
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", marks=" + marks + ", rollNo=" + rollNo + "]";
	}
	
	
}
