package org.com.cay.listener;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageListenerEx2 {

	@Autowired
	//@Qualifier("jmsQueueTemplate")
	//@Qualifier("jmsTopicTemplate")
	private JmsTemplate jmsTemplate;

	public void receive(String message) throws JMSException {

		System.out.println("Get Message: " + message);

	}
}
