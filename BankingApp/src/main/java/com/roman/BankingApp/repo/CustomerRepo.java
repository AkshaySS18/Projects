package com.roman.BankingApp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roman.BankingApp.model.Account;

@Repository
public interface CustomerRepo extends JpaRepository<Account,Integer>{

}
