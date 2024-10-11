package com.example.demo.model;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Component
@Scope("prototype")
@Entity
public class Student {
	
		private String name;
		private int marks;
		@Id
		private int rollno;
		
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
		
		public int getRollno() {
			return rollno;
		}
		
		public void setRollno(int rollno) {
			this.rollno = rollno;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", marks=" + marks + ", rollno=" + rollno + "]";
		}
}
