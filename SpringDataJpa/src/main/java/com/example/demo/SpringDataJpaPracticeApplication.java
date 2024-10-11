package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.model.Student;
import com.example.demo.repo.StudentRepo;

@SpringBootApplication
public class SpringDataJpaPracticeApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataJpaPracticeApplication.class, args);
		Student s1 = context.getBean(Student.class);
		Student s2 = context.getBean(Student.class);
		Student s3 = context.getBean(Student.class);
		StudentRepo repo = context.getBean(StudentRepo.class);
		
//		s1.setName("Rohit");
//		s1.setRollno(21);
//		s1.setMarks(87);
//		
		s2.setName("Jasprit");
		s2.setRollno(18);
		s2.setMarks(85);
		
		s3.setName("Rishabh");
		s3.setRollno(11);
		s3.setMarks(93);
		
		repo.save(s2);
		repo.save(s3);
		
	}

}
