package com.example.activemq;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQSslConnectionFactory;

public class SSLExample {
	
	public static String url = "ssl://localhost:61617";
	private static String subject = "TESTSSLQUEUE";
			
	public static void main(String[] args) throws Exception {
		// Configure the secure connection factory.
		ActiveMQSslConnectionFactory connectionFactory = new ActiveMQSslConnectionFactory(url);
		connectionFactory.setTrustStore("C:/activemq/conf/client.ts");
		connectionFactory.setTrustStorePassword("password");

		// Create the connection.
		Connection connection = connectionFactory.createConnection();
		connection.start();

		// Create the session
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		Destination destination = session.createQueue(subject);

		// Create the producer.
		MessageProducer producer = session.createProducer(destination);
		
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        
        // We will send a small text message saying 'Hello' in Japanese
        TextMessage message = session.createTextMessage("Hello Annad");
     
        
        // Here we are sending the message!
        producer.send(message);
        System.out.println("Sent message '" + message.getText() + "'");
        
        Queue q = session.createQueue(subject);
        QueueBrowser browser = session.createBrowser(q);
        Enumeration enu = browser.getEnumeration();
        List list = new ArrayList();        
          while (enu.hasMoreElements()) {
            TextMessage message1 = (TextMessage) enu.nextElement();          
            list.add(message1.getText());
           }
        System.out.println("Size " + list.size());
        
        
        connection.close();
	}
}
