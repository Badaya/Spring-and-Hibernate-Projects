package com.example.activemq;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class DemoPublisherSubscriberModel implements MessageListener {
	private TopicSession pubSession;
	private TopicPublisher publisher;
	private TopicConnection connection;

	private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

	/* Establish JMS publisher and subscriber */
	public DemoPublisherSubscriberModel(String topicName, String username,
			String password) throws Exception {

		// Look up a JMS connection factory
		TopicConnectionFactory conFactory = new ActiveMQConnectionFactory(url);

		// Create a JMS connection
		connection = conFactory.createTopicConnection(username, password);
		connection.setClientID("");
		// Create JMS session objects for publisher and subscriber
		pubSession = connection.createTopicSession(false,
				Session.AUTO_ACKNOWLEDGE);

		TopicSession subSession = connection.createTopicSession(false,
				Session.AUTO_ACKNOWLEDGE);

		// Look up a JMS topic
		Topic chatTopic = pubSession.createTopic(topicName);

		// Create a JMS publisher and subscriber
		publisher = pubSession.createPublisher(chatTopic);
		TopicSubscriber subscriber1 = subSession.createSubscriber(chatTopic);
		TopicSubscriber subscriber2 = subSession.createDurableSubscriber(
				chatTopic, "sub2");
		TopicSubscriber durableSubscriber = subSession.createDurableSubscriber(
				chatTopic, "sub1");

		// Set a JMS message listener
		subscriber1.setMessageListener(this);
		subscriber2.setMessageListener(this);
		durableSubscriber.setMessageListener(this);

		// Start the JMS connection; allows messages to be delivered
		connection.start();

		// Create and send message using topic publisher
		TextMessage message = pubSession.createTextMessage();
		message.setText(username + ": Hello Friends!");
		publisher.publish(message);

		// subSession.unsubscribe("Dtopic");

	}

	/*
	 * A client can register a message listener with a consumer. A message
	 * listener is similar to an event listener. Whenever a message arrives at
	 * the destination, the JMS provider delivers the message by calling the
	 * listener's onMessage method, which acts on the contents of the message.
	 */
	public void onMessage(Message message) {
		try {
			try {
				Thread.sleep(2000l);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			TextMessage textMessage = (TextMessage) message;
			String text = textMessage.getText();
			System.out.println(text);
		} catch (JMSException jmse) {
			jmse.printStackTrace();
		}
	}

	public static void main(String[] args) {

		try {

			DemoPublisherSubscriberModel demo = new DemoPublisherSubscriberModel(
					"test", "admin", "admin");

			BufferedReader commandLine = new java.io.BufferedReader(
					new InputStreamReader(System.in));

			// closes the connection and exit the system when 'exit' enters in
			// the command line
			while (true) {
				String s = commandLine.readLine();
				if (s.equalsIgnoreCase("exit")) {
					demo.connection.close();
					System.exit(0);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
