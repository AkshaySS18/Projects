package com.roman.JWTDemoApplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.roman.JWTDemoApplication.model.User;





public interface UserRepo extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
