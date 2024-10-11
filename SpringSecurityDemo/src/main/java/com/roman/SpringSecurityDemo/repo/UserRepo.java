package com.roman.SpringSecurityDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.roman.SpringSecurityDemo.model.User;


public interface UserRepo extends JpaRepository<User, Integer>{
	User findByUsername(String username);
}
