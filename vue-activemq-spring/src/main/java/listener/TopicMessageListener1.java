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
		//判断消息类型是TextMessage
		if(message instanceof TextMessage){
			//如果是，则进行强转
			TextMessage textMessage = (TextMessage)message;
			try {
				String jsontext = textMessage.getText();
				if(jsontext!=null){
					News news = JSON.parseObject(jsontext, News.class);
					System.out.println("TopicMessageListener1收到消息: "+news);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}
