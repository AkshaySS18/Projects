package com.roman.BankingApp;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roman.BankingApp.model.Account;
import com.roman.BankingApp.service.CustomerService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
	@Autowired
	public CustomerService service;
	
	@PostMapping
	public Account createAccount(@RequestBody Account account) {
		return service.createAccount(account);
	}
	
	@GetMapping("/{id}")
	public Account getAccount(@PathVariable int id) {
		return service.getAccount(id);
	}
	
	@PostMapping("/{id}/deposit")
	public Account depositToAccount(@PathVariable int id, @RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		return service.deposit(id,amount);
	}
	
	@PostMapping("/{id}/withdraw")
	public Account withdraw(@PathVariable int id, @RequestBody Map<String, Double> request) {
		Double amount = request.get("amount");
		return service.withdraw(id, amount);
	}
}
