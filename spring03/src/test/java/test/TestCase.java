package test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ioc.Bar;
import ioc.Leader;
import ioc.Plane;
import ioc.Reataurant;
import ioc.Student;
import ioc.UserBean;

public class TestCase {
	@Test
	//�������ɨ��
	public void test1(){
		String config="IOC.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		Student stu1 = 
				ac.getBean("stu1",Student.class);
		System.out.println(stu1);
	}
	@Test
	//����������
	public void test2(){
		String config="IOC.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(config);
		Student stu1 = 
				ac.getBean("stu1",Student.class);
		System.out.println(stu1);
		Student stu2 = 
				ac.getBean("stu1",Student.class);
		System.out.println(stu2);
		System.out.println(stu1==stu2);
	}
	@Test
	//����������
	public void test3(){
		String config="IOC.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
	}
	@Test
	//��������������صķ���
	public void test4(){
		String config="IOC.xml";
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Student stu1 = 
				ac.getBean("stu1",Student.class);
		System.out.println(stu1);
		ac.close();
	}	
	@Test
	//����	@Autowired��@Qualifier
	public void test5(){
		String config="IOC.xml";
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Reataurant rea = 
				ac.getBean
				("rest",Reataurant.class);
		System.out.println(rea);
		Bar bar = ac.getBean("bar",Bar.class);
		System.out.println(bar);
	}
	@Test
	//����	@Resource
	public void test6(){
		String config="IOC.xml";
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Leader l = ac.getBean("leader",Leader.class);
		System.out.println(l);
	}
	@Test
	//����	@Value
	public void test7(){
		String config="IOC.xml";
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		UserBean user = ac.getBean("user",UserBean.class);
		System.out.println(user);
	}
	
	@Test
	//����	@Value
	public void test8(){
		String config="IOC.xml";
		AbstractApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		Plane p = ac.getBean("plane",Plane.class);
		System.out.println(p);
	}
}
