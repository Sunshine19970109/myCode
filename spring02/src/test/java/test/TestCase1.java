package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import homework.LoginSerivce;

public class TestCase1 {
	@Test
	public void test1(){
		String config="admin.xml";
		ApplicationContext ac=
				new ClassPathXmlApplicationContext(config);
		LoginSerivce service=
				ac.getBean("LoginSerivce",LoginSerivce.class);
		System.out.println(service);
		
	}
}
