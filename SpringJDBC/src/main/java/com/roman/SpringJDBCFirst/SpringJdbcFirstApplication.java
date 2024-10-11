package com.roman.SpringJDBCFirst;

import java.util.List;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.roman.SpringJDBCFirst.model.Student;
import com.roman.SpringJDBCFirst.service.Studentservice;

@SpringBootApplication
public class SpringJdbcFirstApplication {

	public static void main(String[] args) {
ApplicationContext context=	SpringApplication.run(SpringJdbcFirstApplication.class, args);
  Student s= context.getBean(Student.class);
  s.setRollno(105);
  s.setName("Navin");
  s.setMarks(78);
  Studentservice service=context.getBean(Studentservice.class);
   service.addStudent(s);
   
   List<Student> students=service.getStudents();
   System.out.println(students);
    
	}

}