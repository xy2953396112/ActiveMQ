package com.xzh.pub;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;


public class ActiveMQProducer {
   
	private static String username = ActiveMQConnection.DEFAULT_USER;
	private static String password = ActiveMQConnection.DEFAULT_PASSWORD;
	private static String brokeurl = ActiveMQConnection.DEFAULT_BROKER_URL;
	private static final int SENDNUM=10; // 发送的消息数量
	
	public static void main(String[] args) throws JMSException {
		
		ConnectionFactory connectionFactory;
		Connection connection;
		Session session;//会话接受或者发送的线程
		Destination destination;  //消息目的地
		MessageProducer messageProducer;
		
		connectionFactory = new ActiveMQConnectionFactory(username,password,brokeurl);
		
		connection = connectionFactory.createConnection();
		connection.start();
		session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
		//destination = session.createQueue("FirstQueue1");
		destination = session.createTopic("FirstTopic1");
		messageProducer = session.createProducer(destination);
		sendMessage(session,messageProducer);
		session.commit();
		connection.close();
	}
	
	public static void sendMessage(Session session,MessageProducer messageProducer) throws JMSException{
		
		for(int i=0;i<SENDNUM;i++){
			TextMessage message = session.createTextMessage("ActiveMQ message:"+i);
            System.out.println("发送消息  ActiveMQ message:"+i);
            messageProducer.send(message);
			
		}
		
	}
	
}
