package com.example.activemq;


public class SetSystemProperties {

	public static void main(String[] args) {
		System.setProperty("activemq.home", "C:/activemq");
		System.setProperty("javax.net.ssl.keyStore", "C:/activemq/conf/broker.ks");
		System.setProperty("javax.net.ssl.keyStorePassword", "password");
		System.setProperty("javax.net.ssl.trustStore", "C:/activemq/conf/broker.ts");
		System.setProperty("javax.net.ssl.trustStorePassword", "password");
		
	}
}
