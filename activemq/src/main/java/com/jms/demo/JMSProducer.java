package com.jms.demo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息生产者
 * @author admin
 *
 */
public class JMSProducer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	
    private static final int SENDNUM = 10;//发送的消息数量
	
	
	public static void main(String[] args) {
         ConnectionFactory connectionFactory;//连接工厂
         Connection connection = null;//连接
         Session session;//会话
         Destination destination;//消息的目的地
         MessageProducer messageProducer;//消息生产者
         
         //实例化连接工厂
         connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL);
         //通过连接工厂获取连接
         try {
			connection = connectionFactory.createConnection();
			connection.start();//启动连接
			//创建session,第一个参数是否有事务
			session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			//创建消息队列,(创建队列作为目的地)
			destination = session.createQueue("FirstQueue1");
			//创建消息生产者
			messageProducer = session.createProducer(destination);
			
			sendMessage(session,messageProducer);
			
			//提交事务
			session.commit();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(connection != null){
				try {
					connection.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
	}
	
	/**
	 * 发送消息
	 * @throws Exception 
	 */
	public static void sendMessage(Session session,MessageProducer messageProducer) throws Exception{
		for (int i = 0; i < JMSProducer.SENDNUM; i++) {
			TextMessage message = session.createTextMessage("ActiveMQ 发送的消息"+i);
		    System.out.println("发送消息："+ "ActiveMQ 发送的消息"+i);
		    messageProducer.send(message);
		}
	}

}
