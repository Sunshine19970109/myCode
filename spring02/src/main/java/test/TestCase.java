package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

import autowire.Bar;
import ioc.A;
import ioc.Car;
import ioc.Manager;
import ioc.Restaurant;
import value.ExampleBean;
import value.InfoBean;
import value.SomeBean;
import value.ValueBean;

public class TestCase {
	@Test
	//����set����ע��
	public void test1(){
		String config="ioc.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(config);
		A a = ac.getBean("a1",A.class);
		a.execute();
	}
	@Test
	//���Թ�����ע��
	public void test3(){
		String config="ioc.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(config);
		Manager mg1 = 
				ac.getBean("mg1",Manager.class);
		System.out.println(mg1);
	}
	@Test
	//���Թ�����ע����ϰ
	public void testEngineerToCar(){
		String config="test1.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(config);
		Car car = ac.getBean("car",Car.class);
		System.out.println(car);
	}
	@Test
	//�����Զ�װ��
	public void test4(){
		String config="autowire.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(config);
		Bar bar = ac.getBean("bar",Bar.class);
		System.out.println(bar);
	}
	@Test
	//����ע��������͵�ֵ
	public void test5(){
		String config="value.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(config);
		ValueBean v = ac.getBean("valueBean",ValueBean.class);
		System.out.println(v);
	}
	@Test
	//����	�������͵�ֵ��ע��
	public void test6(){
		String config="value.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(config);
		ExampleBean eb = 
				ac.getBean("eb1",ExampleBean.class);
		System.out.println(eb);
	}
	
	@Test
	//��ȡ�����ļ�������
	public void test7(){
		String config="value.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(config);
		Properties props = 
				ac.getBean("config",Properties.class);
		System.out.println(props);
	}
	
	@Test
	//������ϰSomeBean�������÷�ʽע�����ּ���
	public void testSomeBean(){
		String config="test2.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(config);
		SomeBean some = 
				ac.getBean("some",SomeBean.class);
		System.out.println(some);
	}
	@Test
	//�Ͽ�setע����ϰ
	public void test2(){
		String config="test.xml";
		ApplicationContext ac=
			new ClassPathXmlApplicationContext(config);
		Restaurant r =ac.getBean("r1",Restaurant.class);
		r.execute();
	}
	
	@Test
	//����spring���ʽ
	public void test8(){
		String config="value.xml";
		ApplicationContext ac=
		new ClassPathXmlApplicationContext(
				config);
		InfoBean ib1 =ac.getBean("ib1",InfoBean.class);
		System.out.println(ib1);
	}
}
















