package com.roman.SpringSecurityDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.roman.SpringSecurityDemo.model.User;
import com.roman.SpringSecurityDemo.model.UserPrincipal;
import com.roman.SpringSecurityDemo.repo.UserRepo;

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
