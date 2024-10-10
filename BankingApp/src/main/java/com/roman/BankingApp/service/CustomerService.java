package com.roman.BankingApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roman.BankingApp.model.Account;
import com.roman.BankingApp.repo.CustomerRepo;

@Service
public class CustomerService {
	
	@Autowired
	public CustomerRepo repo;

	public Account createAccount(Account account) {
		return repo.save(account);
	}

	public Account getAccount(int id) {		
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Account not found"));
	}

	public Account deposit(int id, Double amount) {
		Account account = getAccount(id);
		account.setBalance(account.getBalance()+amount);
		return repo.save(account);
	}
	
	public Account withdraw(int id, Double amount) {
		Account account = getAccount(id);
		account.setBalance(account.getBalance()-amount);
		return repo.save(account);		
	}
	
}
