package com.example.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.spring.model.Evaluator;

public class MainApplication {

	public static void main(String[] args) throws Exception {
	    ApplicationContext ctx = new ClassPathXmlApplicationContext(
	        "context.xml");
	    Evaluator reporter = (Evaluator) ctx.getBean("evaluator");
	    reporter.evaluate(13);
	  }
}
