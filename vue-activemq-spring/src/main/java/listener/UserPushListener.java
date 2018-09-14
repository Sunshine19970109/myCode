package listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

import entity.User;
@Component("userPushListener")
public class UserPushListener implements MessageListener {

	public void onMessage(Message message) {
		TextMessage textMessage =(TextMessage)message;
		try {
			//��ȡ����
			String jsonStr = textMessage.getText();
			System.out.println("�յ���Ϣ:"+jsonStr);
			if(jsonStr!=null){
				User info = JSON.parseObject(jsonStr,User.class);
				System.out.println("-----�����û���Ϣ��ʼ------");
				System.out.println(info);
				System.out.println("-----�����û���Ϣ����------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}