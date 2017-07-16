package com.xuwei.activemq;

import java.util.UUID;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class Sender1 {
    private static final int SEND_NUMBER = 5;

    public static void main(String[] args) {
        // ConnectionFactory ：连接工厂，JMS 用它创建连接
        ConnectionFactory connectionFactory;
        // Connection ：JMS 客户端到JMS Provider 的连接
        Connection connection = null;
        // Session： 一个发送或接收消息的线程
        Session session = null;
        // Destination ：消息的目的地;消息发送给谁.
        Destination destination;
        // MessageProducer：消息发送者
        MessageProducer producer;
        // TextMessage message;
        //1. 构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar
        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://192.168.1.139:61616");
        try {
            //2. 构造从工厂得到连接对象
            connection = connectionFactory.createConnection();
            // 3.启动
            connection.start();
            //4. 获取操作连接,使用食物提交则必须session.commit之后才能提交
//            session = connection.createSession(Boolean.TRUE,
//                    Session.AUTO_ACKNOWLEDGE);
            //使用client签收
            session = connection.createSession(Boolean.TRUE,
            		Session.AUTO_ACKNOWLEDGE);
            //5. 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
            destination = session.createQueue("FirstQueue");
            //6. 得到消息生成者【发送者】
            producer = session.createProducer(null);
//            producer = session.createProducer(destination);
            // 设置不持久化，此处学习，实际根据项目决定
//            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            // 构造消息，此处写死，项目就是参数，或者方法获取
            sendMessage(destination,session, producer);
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            try {
//            	if(session != null){
//            		session.close();
//            	}
//                if (null != connection)
//                    connection.close();
//            } catch (Throwable ignore) {
//            }
        }
    }

    public static void sendMessage(final Destination destination,final Session session, final MessageProducer producer)
            throws Exception {
    	new Thread(){

			@Override
			public void run() {
				while(true){
					UUID id =  UUID.randomUUID();
					 TextMessage message;
					try {
						message = session
						         .createTextMessage("ActiveMq 发送的消息" +id.toString());
						  System.out.println("发送消息：" + "ActiveMq 发送的消息" + id.toString());
						  // 发送消息到目的地方
//				             producer.send(message);
//						  producer.send(destination, message, deliveryMode, priority, timeToLive);
						  producer.send(destination, message, DeliveryMode.NON_PERSISTENT, 4, 1000*60);
				             session.commit();
				        Thread.currentThread().sleep(10);
					} catch (JMSException e) {
						e.printStackTrace();
					}
		            
					catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			
	           
			}
    		
    	}.start();
//        for (int i = 1; i <= SEND_NUMBER; i++) {
//           
//        }
    }
}
    