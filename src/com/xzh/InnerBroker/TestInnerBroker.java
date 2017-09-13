package com.xzh.InnerBroker;

import org.apache.activemq.broker.BrokerService;

/**
 * 
 * @author lenovo
 *     2017.7.17
 */
public class TestInnerBroker {
    public static void main(String[] args) throws Exception {
		
    	BrokerService   bs = new BrokerService();
    	
    	bs.setUseJmx(true);
    	
    	bs.addConnector("tcp://localhost:61616");
    	
    	bs.start();
	}
}
