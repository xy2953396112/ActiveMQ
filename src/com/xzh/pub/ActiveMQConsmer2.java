package com.xzh.pub;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class ActiveMQConsmer2 {
    
	private static final String USERNAME=ActiveMQConnection.DEFAULT_USER; // Ä¬ÈÏµÄÁ¬½ÓÓÃ»§Ãû
	private static final String PASSWORD=ActiveMQConnection.DEFAULT_PASSWORD; // Ä¬ÈÏµÄÁ¬½ÓÃÜÂë
	private static final String BROKEURL=ActiveMQConnection.DEFAULT_BROKER_URL; // Ä¬ÈÏµÄÁ¬½ÓµØÖ·

    public static void main(String[] args) throws JMSException {
    	ConnectionFactory connectionFactory; // Á¬½Ó¹¤³§
		Connection connection = null; // Á¬½Ó
		Session session; // »á»° ½ÓÊÜ»òÕß·¢ËÍÏûÏ¢µÄÏß³Ì
		Destination destination; // ÏûÏ¢µÄÄ¿µÄµØ
		MessageConsumer messageConsumer; // ÏûÏ¢µÄÏû·ÑÕß
		
		// ÊµÀý»¯Á¬½Ó¹¤³§
		connectionFactory=new ActiveMQConnectionFactory(ActiveMQConsmer2.USERNAME,ActiveMQConsmer2.PASSWORD,ActiveMQConsmer2.BROKEURL); 
	    //System.out.println("BROKEURL:"+BROKEURL);
		connection  = connectionFactory.createConnection();
		connection.start();
		session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
		//destination = session.createQueue("FirstQueue1");
		destination = session.createTopic("FirstTopic1");
		messageConsumer=session.createConsumer(destination); 
        
		messageConsumer.setMessageListener(new Listener2()); //注册消息监听
    }

}
