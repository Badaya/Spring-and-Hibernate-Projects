package com.example.spring123;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class maindemo {
	public static void main(String args[]) throws InterruptedException{
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"sprindemo.xml");
		Bar bar = applicationContext.getBean("bar", Bar.class);
		bar.printFooName();
		applicationContext.registerShutdownHook();

	}

}
