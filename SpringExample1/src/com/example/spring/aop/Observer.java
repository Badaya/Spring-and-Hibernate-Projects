package com.example.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class Observer {

	@Before("execution(* com.example.spring.model.*.*(..))")
	public void beforeAdvice(JoinPoint jp) {
		System.out.println("Creating  object"
				+ jp.getTarget().getClass().getName());
	}

	/**
	 * This method will execute after executing any method
	 */
	@After("execution(* com.example.spring.model.*.*(..))")
	public void afterAdvice(JoinPoint jp) {
		System.out.println("Created  object"
				+ jp.getTarget().getClass().getName());
	}
}
