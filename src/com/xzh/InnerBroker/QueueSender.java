package com.xzh.InnerBroker;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.spring.ActiveMQConnectionFactory;

public class QueueSender {
   
	public static void main(String[] args) {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		
		Connection connection = connectionFactory.createConnection();
		
		connection.start();
		
		Session session = connection.createSession(Boolean.TRUE,Session.CLIENT_ACKNOWLEDGE);
	
	    Destination destination = session.createQueue("my-queue");
	    
	    MessageProducer producer = session.createProducer(destination);
	    
	    for(int i =0;i<3;i++){
	    	
	    	MapMessage message  = session.createMapMessage();
	    	message.setStringProperty("extra"+i, "okok");
	    	
	    	message.setString("message--"+i,"my map message "+i);
	    	
	    	producer.send(message);
	    }
	}
}
