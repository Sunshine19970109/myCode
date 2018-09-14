package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.MessageService;
import basic.Teacher;
import homework.ExampleBean;

public class TestCase {
	
	
	@Test
	/**
	 * ������������ӳټ���
	 */
	public void test1(){
		String config = "basic.xml";
		//����spring����
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext(config);
				
		//ͨ���������bean
		//Ĭ�����������һ�������Զ��Ѷ��󴴽��á�
		Teacher t1 = ac.getBean("t1",Teacher.class);
		Teacher t2= ac.getBean("t1",Teacher.class);
		System.out.println(t1==t2);
	}
	
	
	@Test
	//��������������ص���������
	public void test2(){
		String config = "basic.xml";
		//����spring����
		/*
		 * ApplicationContext�ӿڵ��в�û���ṩ�ر�����
		 * �ķ���(close����)����Ҫ�����ӽӿ�
		 */
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext(config);
		MessageService ms = ac.getBean
				("ms1",MessageService.class);
		//�رսӿ�
		ac.close();
	}
	
	@Test
	//��ҵ����
	public void homeworkTest(){
		String config = "homework.xml";
		AbstractApplicationContext aac = 
				new ClassPathXmlApplicationContext(config);
		ExampleBean eb = aac.getBean
				("exam",ExampleBean.class);
		aac.close();
	}
}





































