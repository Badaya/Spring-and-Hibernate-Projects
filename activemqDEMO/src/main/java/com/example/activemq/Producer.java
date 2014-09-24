package com.example.activemq;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Producer {
	 // URL of the JMS server. DEFAULT_BROKER_URL will just mean
    // that JMS server is on localhost
	//tcp://localhost:61616
    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;  

    // Name of the queue we will be sending messages to
    private static String subject = "TESTQUEUE";

    public static void main(String[] args) throws JMSException {
        // Getting JMS connection from the server and starting it
        ConnectionFactory connectionFactory =
            new ActiveMQConnectionFactory(url);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        
        
        // JMS messages are sent and received using a Session. We will
        // create here a non-transactional session object. If you want
        // to use transactions you should set the first parameter to 'true'
        Session session = connection.createSession(false,
            Session.AUTO_ACKNOWLEDGE);

        // Destination represents here our queue 'TESTQUEUE' on the
        // JMS server. You don't have to do anything special on the
        // server to create it, it will be created automatically.
        Destination destination = session.createQueue(subject);
        
       
        // MessageProducer is used for sending messages (as opposed
        // to MessageConsumer which is used for receiving them)
        MessageProducer producer = session.createProducer(destination);
        
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        producer.setPriority(7);

        TextMessage message = session.createTextMessage("Hello Anand");
        message.setBooleanProperty("bool", true);
        message.setIntProperty("int", 10);
        
        
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
