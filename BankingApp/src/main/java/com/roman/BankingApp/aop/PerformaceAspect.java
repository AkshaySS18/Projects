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
public class PerformaceAspect {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
	
	@Around("execution(* com.roman.BankingApp.service.CustomerService.getAccount(..))")
	public Object callPerformAspect(ProceedingJoinPoint jp) throws Throwable {
		long startTime = System.currentTimeMillis();
		Object obj = jp.proceed();
		long endTime = System.currentTimeMillis();
		LOGGER.info("Time taken for method "+jp.getSignature().getName()+" is "+(endTime-startTime)+" milliSeconds");
		return obj;
	}
}
