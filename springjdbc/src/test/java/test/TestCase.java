package test;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmployDAO;
import entity.Employee;

public class TestCase {
	private EmployDAO dao;
	@Before
	/*
	 * @Before修饰的方法会在其他测试方法运行之前
	 * 先执行
	 */
	public void init(){
		String config = 
				"spring-jdbc.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(config);
		dao = 
				ac.getBean("employDAO",EmployDAO.class);
		
	}
	@Test
	public void test1(){
		Employee e = new Employee();
		e.setName("Give King");
		e.setAge(22);
		dao.save(e);
	}
	@Test
	public void test2(){
		List<Employee> emps = dao.findAll();
		Iterator<Employee> it = emps.iterator();
		while (it.hasNext()) {
			Employee employee = (Employee) it.next();
			System.out.println(employee);
		}
	}
	@Test
	public void test3(){
		Employee employee = dao.findById(3);
		System.out.println(employee);
	}
	@Test
	public void test4(){
		Employee e = dao.findById(1);
		System.out.println(e);
		e.setAge(50);
		dao.modify(e);
		e = dao.findById(1);
		System.out.println(e);
	}
	@Test
	public void test5(){
		dao.delete(1);
		dao.findById(1);
	}
}
