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
	//测试set方法注入
	public void test1(){
		String config="ioc.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(config);
		A a = ac.getBean("a1",A.class);
		a.execute();
	}
	@Test
	//测试构造器注入
	public void test3(){
		String config="ioc.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(config);
		Manager mg1 = 
				ac.getBean("mg1",Manager.class);
		System.out.println(mg1);
	}
	@Test
	//测试构造器注入练习
	public void testEngineerToCar(){
		String config="test1.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(config);
		Car car = ac.getBean("car",Car.class);
		System.out.println(car);
	}
	@Test
	//测试自动装配
	public void test4(){
		String config="autowire.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(config);
		Bar bar = ac.getBean("bar",Bar.class);
		System.out.println(bar);
	}
	@Test
	//测试注入基本类型的值
	public void test5(){
		String config="value.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(config);
		ValueBean v = ac.getBean("valueBean",ValueBean.class);
		System.out.println(v);
	}
	@Test
	//测试	集合类型的值的注入
	public void test6(){
		String config="value.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(config);
		ExampleBean eb = 
				ac.getBean("eb1",ExampleBean.class);
		System.out.println(eb);
	}
	
	@Test
	//读取属性文件的内容
	public void test7(){
		String config="value.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(config);
		Properties props = 
				ac.getBean("config",Properties.class);
		System.out.println(props);
	}
	
	@Test
	//测试练习SomeBean采用引用方式注入四种集合
	public void testSomeBean(){
		String config="test2.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(config);
		SomeBean some = 
				ac.getBean("some",SomeBean.class);
		System.out.println(some);
	}
	@Test
	//上课set注入练习
	public void test2(){
		String config="test.xml";
		ApplicationContext ac=
			new ClassPathXmlApplicationContext(config);
		Restaurant r =ac.getBean("r1",Restaurant.class);
		r.execute();
	}
	
	@Test
	//测试spring表达式
	public void test8(){
		String config="value.xml";
		ApplicationContext ac=
		new ClassPathXmlApplicationContext(
				config);
		InfoBean ib1 =ac.getBean("ib1",InfoBean.class);
		System.out.println(ib1);
	}
}
















