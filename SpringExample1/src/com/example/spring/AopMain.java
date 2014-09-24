package com.example.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.spring.model.Employee;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"aop-context.xml");
		Employee employee = (Employee) context.getBean("employee");
		employee.getName();
		employee.getCompany();
	}

}
