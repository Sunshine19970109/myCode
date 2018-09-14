package service.impl;


import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import entity.User;
import service.PushService;
@Service("userPushService")
public class UserPushServiceImpl implements PushService {

	@Resource(name="internalJmsTemplate")
	private JmsTemplate jmsTemplate;
	
	@Autowired
	@Qualifier("userServiceQueue")
	private Destination destination;
	

	/*
	 * 这里的消息是否不能改，发送的消息，发送中不能被改
	 */
	public void push(final Object info) {
		pushExcutor.execute(new Runnable() {
			
			public void run() {
				jmsTemplate.send(destination,new MessageCreator() {
					
					public Message createMessage(Session session) throws JMSException {
						User user = (User)info;
						return session.createTextMessage(JSON.toJSONString(user));
					}
				});
			}
		});
	}

}
