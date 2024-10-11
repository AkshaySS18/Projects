package com.roman.JWTDemoApplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.roman.JWTDemoApplication.dao.UserRepo;
import com.roman.JWTDemoApplication.model.User;
import com.roman.JWTDemoApplication.model.UserPrincipal;


@Service
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repo.findByUsername(username);
		if(user == null) {
			System.out.println("404 user not found");
			throw new UsernameNotFoundException("User not found");
		}
		return new UserPrincipal(user);
	}
	
}
