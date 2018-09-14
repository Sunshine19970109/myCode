package test;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.EmployeeDAO;
import entity.Emp;
import entity.Employee;
public class TestCase {
	public EmployeeDAO dao;
	@Before
	public void init(){
		String config="mybatis-spring.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(config);
		dao = ac.getBean("empDAO",EmployeeDAO.class);
	}
	@Test
	public void test1(){
		List<Employee> emps = dao.findAll();
		System.out.println(emps);	
	}
	@Test
	public void test2(){
		Employee employee  = dao.findById(2);
		System.out.println(employee);
	}
	@Test
	public void test3(){
		Map m = dao.findById2(2);
		System.out.println(m);
		System.out.println(m.get("NAME"));
	}
	@Test
	public void test4(){
		Emp e = dao.findById3(2);
		System.out.println(e);
	}
	@Test
	public void test5(){
		Employee e = dao.findById(2);
		e.setName("Â½¼ª");
		e.setAge(18);
		dao.modify(e);
		System.out.println(dao.findById(2));
	}
	@Test
	public void test6(){
		Employee e = new Employee();
		e.setAge(20);
		e.setName("Ð¡¸ßºìºì");
		dao.save(e);
	}
}
