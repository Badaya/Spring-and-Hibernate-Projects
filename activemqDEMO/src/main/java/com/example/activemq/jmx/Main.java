package com.example.activemq.jmx;

import java.io.IOException;
import java.net.ConnectException;
import java.rmi.ConnectIOException;

import javax.management.InstanceNotFoundException;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.broker.jmx.QueueViewMBean;
import org.apache.activemq.command.ActiveMQDestination;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {

		try {
			
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-activemq.xml");

		QueueSizeCounter queueCounter = (QueueSizeCounter) ctx.getBean("queueCounter");

		String queueName = "TESTQUEUE1";
		
		//Add Queue
/*		queueCounter.AddOrDeleteQueue("add", queueName);
		long queueSize = queueCounter.getQueueSize(queueName);
		System.out.println("Size of " + queueName + " : " + queueSize);

		//Remove Queue
		queueCounter.AddOrDeleteQueue("remove", queueName);*/
		
		/*System.out.println(queueCounter.getNumberOfQueueAndTopic());
		queueCounter.addQueue("aaa1");*/
		
		queueCounter.removeQueue("TESTQUEUE");
		} catch (ConnectException e) {
			System.out.println("Connect Exception");
			System.out.println("Connection problem");
		}catch(java.rmi.ConnectException ee){
			System.out.println("ConnectIOException");
		}
		catch(InstanceNotFoundException ee){
			System.out.println("IO Exception" + ee.getMessage());
			ee.printStackTrace();
		}
		catch(Exception ee){
			System.out.println("aaaaaaa");
			ee.printStackTrace();
		}
	}
}
