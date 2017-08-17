package org.com.cay.service.impl;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.com.cay.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements IMessageService {

	@Autowired
	//@Qualifier("jmsQueueTemplate")
	//@Qualifier("jmsTopicTemplate")
	private JmsTemplate jmsTemplate;

	@Autowired
	//@Qualifier(value = "queueDestination")
	//@Qualifier(value = "topicDestination")
	private Destination destination;

	@Override
	public void sendMessage(String message) {
		// TODO Auto-generated method stub
		
		if(destination instanceof ActiveMQQueue){
			//队列模式
			message = "队列模式：" + message;
		}else if(destination instanceof ActiveMQTopic){
			//主题模式
			message = "主题模式：" + message;
		}
		
		send(message);
	}
	
	private void send(final String message){
		jmsTemplate.send(destination, new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				// TODO Auto-generated method stub
				TextMessage textMessage = session.createTextMessage(message);
				return textMessage;
			}
		});
	}

}
