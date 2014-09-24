package com.example.activemq.jmx;

import java.util.Map;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;

import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.apache.activemq.broker.jmx.QueueViewMBean;


public class QueueSizeCounter {

	private MBeanServerConnection mBeanServerConnection;

	public Long getQueueSize(String queueName) {
		Long queueSize = null;
		try {

			ObjectName objectNameRequest = new ObjectName(
					"org.apache.activemq:type=Broker,brokerName=localhost,destinationType=Queue,destinationName=TESTQUEUE");
							
			
			queueSize = (Long) mBeanServerConnection.getAttribute(objectNameRequest, "QueueSize");
			
			return queueSize;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return queueSize;
	}
	
	public void AddOrDeleteQueue(String operation, String queueName){
		
		try {
			String operationName = "";//operation like addQueue or removeQueue
			if(operation.equals("add")){
				operationName = "addQueue";
			}else if(operation.equals("remove")){
				operationName = "removeQueue";
			}
			
			String parameter = queueName;   // Queue name
			ObjectName objectName = new ObjectName("org.apache.activemq:brokerName=localhost,type=Broker");
			Object[] params = {parameter};
			String[] sig = {"java.lang.String"};
			mBeanServerConnection.invoke(objectName, operationName, params, sig); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addQueue(String queueName) throws Exception{
		ObjectName objectName = new ObjectName("org.apache.activemq:brokerName=localhost,type=roker");
		BrokerViewMBean mbean = (BrokerViewMBean) MBeanServerInvocationHandler.newProxyInstance(mBeanServerConnection, objectName,BrokerViewMBean.class, true);
		mbean.addQueue(queueName);
	}

	public void removeQueue(String queueName) throws Exception{
		ObjectName objectName = new ObjectName("org.apache.activemq:brokerName=localhost,type=Broker");
		BrokerViewMBean mbean = (BrokerViewMBean) MBeanServerInvocationHandler.newProxyInstance(mBeanServerConnection, objectName,BrokerViewMBean.class, true);
//		mbean.removeQueue(queueName);
		
		for (ObjectName name : mbean.getQueues()) {
		    QueueViewMBean queueMbean = (QueueViewMBean) MBeanServerInvocationHandler.newProxyInstance(mBeanServerConnection, name, QueueViewMBean.class, true);
		    CompositeData data = queueMbean.getMessage("ID:Anand-PC-60059-1407148181262-1:4:1:1:1");
		    if(data != null){
		    	
		    	System.out.println("adasdasd" + data.get("Text"));
		    	queueMbean.removeMessage("ID:Anand-PC-60059-1407148181262-1:3:1:1:1");
		    	
		    }
		    
		    Map<String, String> map = queueMbean.getMessageGroups();
		    System.out.println(map.size());
		    for (Map.Entry<String, String> entry : map.entrySet())
		    {
		        System.out.println(entry.getKey() + "/" + entry.getValue());
		    }
		    if (queueMbean.getName().equals(queueName)) {
		    	
		    	
		    	System.out.println("removed");
		    	break;
		    }
		} 
	}
	
	public String getNumberOfQueueAndTopic() throws MalformedObjectNameException{
		ObjectName objectName = new ObjectName("org.apache.activemq:brokerName=localhost,type=Broker");
		BrokerViewMBean mbean = (BrokerViewMBean) MBeanServerInvocationHandler.newProxyInstance(mBeanServerConnection, objectName,BrokerViewMBean.class, true);
		int numberOfQueue = mbean.getQueues().length;
		int numberOfTopic = mbean.getTopics().length;
	
		return "Number of Queue is:"+numberOfQueue +" And Number of Topic is:"+numberOfTopic;
	}
	
	
	
	public void setmBeanServerConnection(MBeanServerConnection mBeanServerConnection) {
		this.mBeanServerConnection = mBeanServerConnection;
	}
}
