package demo.example.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.spring.model.Evaluator;

public class springexample {

	public static void main(String[] args) throws Exception {
	    ApplicationContext ctx = new ClassPathXmlApplicationContext(
	        "context.xml");
	    NewsFeedManager manage= (NewsFeedManager) ctx.getBean("newsFeedManager");
	    manage.printNews();
	  }
	
	
}
