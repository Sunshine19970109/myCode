package listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.listener.adapter.AbstractAdaptableMessageListener;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import entity.News;
@Component("topicMessageListener1")
public class TopicMessageListener1 extends AbstractAdaptableMessageListener{

	public void onMessage(Message message, Session session) throws JMSException {
		//�ж���Ϣ������TextMessage
		if(message instanceof TextMessage){
			//����ǣ������ǿת
			TextMessage textMessage = (TextMessage)message;
			try {
				String jsontext = textMessage.getText();
				if(jsontext!=null){
					News news = JSON.parseObject(jsontext, News.class);
					System.out.println("TopicMessageListener1�յ���Ϣ: "+news);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}
