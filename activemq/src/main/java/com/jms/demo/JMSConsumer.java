package com.jms.demo;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.swing.text.StyledEditorKit.BoldAction;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;


/**
 *  消息消费者
 * @author admin
 *
 */
public class JMSConsumer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	
   public static void main(String[] args) {
	   ConnectionFactory connectionFactory;//连接工厂
       Connection connection = null;//连接
       Session session;//会话
       Destination destination;//消息的目的地
       MessageConsumer messageConsumer;//消息消费者
       
       //实例化连接工厂
       connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, BROKEURL); 
		try {
			connection = connectionFactory.createConnection();
			connection.start();//启动连接
			//创建session,第一个参数是否有事务
			session = connection.createSession(false, Session.CLIENT_ACKNOWLEDGE);
			//创建消息队列,(创建队列作为目的地),名称要对应
			destination = session.createQueue("FirstQueue1");
			//创建消息消费者
			messageConsumer = session.createConsumer(destination);
			
			//使用监听器监听发送过来的消息
			messageConsumer.setMessageListener(new Listener());
			//一直在监听，循环等待
//			while(true){
//				TextMessage textMessage = (TextMessage) messageConsumer.receive();
//				textMessage.acknowledge();
//			    if(textMessage != null){
//			    	System.out.println("收到消息："+textMessage.getText());
//			    }
////			    session.commit();
//			}
			
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
   }
}
