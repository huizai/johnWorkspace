package com.jms.demo;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * 消息监听器
 * @author admin
 *
 */
public class Listener implements MessageListener{


	public void onMessage(Message message) {
		try {
			System.out.println("监听器收到的消息："+((TextMessage)message).getText());
			message.acknowledge();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}
   
}
