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
	 * 测试作用域和延迟加载
	 */
	public void test1(){
		String config = "basic.xml";
		//启动spring容器
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext(config);
				
		//通过容器获得bean
		//默认情况下容器一启动会自动把对象创建好。
		Teacher t1 = ac.getBean("t1",Teacher.class);
		Teacher t2= ac.getBean("t1",Teacher.class);
		System.out.println(t1==t2);
	}
	
	
	@Test
	//测试生命周期相关的两个方法
	public void test2(){
		String config = "basic.xml";
		//启动spring容器
		/*
		 * ApplicationContext接口当中并没有提供关闭容器
		 * 的方法(close方法)，需要用其子接口
		 */
		AbstractApplicationContext ac = 
				new ClassPathXmlApplicationContext(config);
		MessageService ms = ac.getBean
				("ms1",MessageService.class);
		//关闭接口
		ac.close();
	}
	
	@Test
	//作业测试
	public void homeworkTest(){
		String config = "homework.xml";
		AbstractApplicationContext aac = 
				new ClassPathXmlApplicationContext(config);
		ExampleBean eb = aac.getBean
				("exam",ExampleBean.class);
		aac.close();
	}
}





































