package com.roman.BankingApp.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.roman.BankingApp.service.CustomerService;

@Component
@Aspect
public class ValidationAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
	
	@Around("execution(* com.roman.BankingApp.service.CustomerService.getAccount(..)) && args(postID)")
	public Object callValidateMethod(ProceedingJoinPoint jp, int postID) throws Throwable {
		if(postID < 0) {
			LOGGER.info("PostID is negative, so updating it");
			postID = -postID;
			LOGGER.info("PostID is updated");
		}
		Object obj = jp.proceed(new Object[] {postID});
		return obj;
	}
}
