package com.roman.SpringJDBCPractice;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.roman.SpringJDBCPractice.model.Student;
import com.roman.SpringJDBCPractice.service.StudentService;

@SpringBootApplication
public class SpringJdbcPracticeApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcPracticeApplication.class, args);
		Student s = context.getBean(Student.class);
//		s.setName("Rakshith");
//		s.setRollNo(21);
//		s.setMarks(93);
		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s);
		
		List<Student> students = service.getAllStudents();
		System.out.println(students); 
	}
	

}
