package com.context.provider;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextProvider implements ApplicationContextAware {
	static ApplicationContext context=null;
	@Autowired
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		context=ctx;
		
	}
	public static ApplicationContext getApplicationContext() {
		return context;
	}

}
