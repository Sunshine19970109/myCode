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

	//ע��jmsTemplate,�������ʹ���Զ�װ��
	@Resource(name="topicJmsTemplate")
	private JmsTemplate jmsTemplate;
	//ע��destination
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