package activemqtest.test;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;


public class ActiveMQTest {
	//���Ͷ�
	public void testMQProducerQueue() throws Exception{
		//1�������������Ӷ�����Ҫ�ƶ�ip�Ͷ˿ں�
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.126.128:61616");
        //2��ʹ�����ӹ�������һ�����Ӷ���
        Connection connection = connectionFactory.createConnection();
        //3����������
        connection.start();
        //4��ʹ�����Ӷ��󴴽��Ự��session������
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5��ʹ�ûỰ���󴴽�Ŀ����󣬰���queue��topic��һ��һ��һ�Զࣩ
        Queue queue = session.createQueue("test-queue");
        //6��ʹ�ûỰ���󴴽������߶���
        MessageProducer producer = session.createProducer(queue);
        //7��ʹ�ûỰ���󴴽�һ����Ϣ����
        TextMessage textMessage = session.createTextMessage("hello!test-queue");
        //8��������Ϣ
        producer.send(textMessage);
        //9���ر���Դ
        producer.close();
        session.close();
        connection.close();
    }
	//���ն�
	 public void TestMQConsumerQueue() throws Exception{
	        //1�������������Ӷ�����Ҫ�ƶ�ip�Ͷ˿ں�
	        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.126.128:61616");
	        //2��ʹ�����ӹ�������һ�����Ӷ���
	        Connection connection = connectionFactory.createConnection();
	        //3����������
	        connection.start();
	        //4��ʹ�����Ӷ��󴴽��Ự��session������
	        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        //5��ʹ�ûỰ���󴴽�Ŀ����󣬰���queue��topic��һ��һ��һ�Զࣩ
	        Queue queue = session.createQueue("test-queue");
	        //6��ʹ�ûỰ���󴴽������߶���
	        MessageConsumer consumer = session.createConsumer(queue);
	        //7����consumer����������һ��messageListener��������������Ϣ
	        consumer.setMessageListener(new MessageListener() {
	            public void onMessage(Message message) {
	                // TODO Auto-generated method stub
	                if(message instanceof TextMessage){
	                    TextMessage textMessage = (TextMessage)message;
	                    try {
	                        System.out.println(textMessage.getText());
	                    } catch (JMSException e) {
	                        // TODO Auto-generated catch block
	                        e.printStackTrace();
	                    }
	                }
	            }
	        });
	        //8������ȴ������û���Ϣ
	        System.in.read();
	        //9���ر���Դ
	        consumer.close();
	        session.close();
	        connection.close();
	    }
}