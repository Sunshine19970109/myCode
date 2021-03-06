package service.impl;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import entity.News;
import service.PushService;
@Service("newsPushService")
public class NewsPushServiceImpl implements PushService {

	//注入jmsTemplate,这里可以使用自动装配
	@Resource(name="topicJmsTemplate")
	private JmsTemplate jmsTemplate;
	//注入destination
	@Resource(name="newsServiceTopic")
	private Destination destination;
	
	public void push(final Object info) {
		pushExcutor.execute(new Runnable() {
			public void run() {
				jmsTemplate.send(destination, new MessageCreator() {
					public Message createMessage(Session session) throws JMSException {
						News news = (News)info;
						Message message = session.createTextMessage(JSON.toJSONString(news));
						return message;
					}
				});
			}
		});
	}

}
