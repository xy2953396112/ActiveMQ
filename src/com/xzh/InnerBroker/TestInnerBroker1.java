package com.xzh.InnerBroker;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

public class TestInnerBroker1 {
   public static void main(String[] args) throws URISyntaxException, Exception {
	
	   String uri ="properties:broker.properties";
	   
	   BrokerService broker1 = BrokerFactory.createBroker(new URI(uri));
	   
	   broker1.addConnector("tcp://localhost:61616");
	   
	   broker1.start();
}
}
