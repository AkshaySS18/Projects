package com.roman.BankingApp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.roman.BankingApp.service.CustomerService;

@Component
@Aspect
public class LoggingAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

	@Before("execution(* com.roman.BankingApp.service.CustomerService.getAccount(..))")
	public void callMethodBefore(JoinPoint jp) {
		LOGGER.info("Method called "+jp.getSignature().getName());
	}
	
	@After("execution(* com.roman.BankingApp.service.CustomerService.getAccount(..))")
	public void callMethodAfter(JoinPoint jp) {
		LOGGER.info("Method called successfully "+jp.getSignature().getName());
	}
	
	@AfterThrowing("execution(* com.roman.BankingApp.service.CustomerService.getAccount(..))")
	public void callMethodException(JoinPoint jp) {
		LOGGER.info("Method encountered some errors "+jp.getSignature().getName());
	}
	
	@AfterReturning("execution(* com.roman.BankingApp.service.CustomerService.getAccount(..))")
	public void callMethodSucces(JoinPoint jp) {
		LOGGER.info("Method returned successfully "+jp.getSignature().getName());
	}
}
