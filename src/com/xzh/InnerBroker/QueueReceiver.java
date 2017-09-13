package com.xzh.InnerBroker;

import java.util.Enumeration;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;



public class QueueReceiver {
   
	public static void main(String[] args) throws JMSException {
		
		ConnectionFactory cf = new ActiveMQConnectionFactory(
				"tcp://localhost:61616");
		
		Connection connection = cf.createConnection();
		connection.start();
		
		Enumeration names = connection.getMetaData().getJMSXPropertyNames();
		while(names.hasMoreElements()){
			String name = (String)names.nextElement();
			System.out.println("jmsx name==="+name);
		}
		
		final Session session = connection.getMetaData().getJMSXPropertyNames(
				Boolean.FALSE,Session.CLIENT_ACKNOWLEDGE);
		Destination destination = session.createQueue("my-queue");
		
		MessageConsumer consumer = session.createConsumer(destination);
		
		int i =0 ;
		
		while(i <3){
			
			MapMessage message = (MapMessage) consumer.receive();
			
		}
		
	
	    
	}
}
