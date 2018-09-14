package test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DeptDAO;
import dao.DeptDAOImpl;
import entity.Dept;

public class TestCase {
	private DeptDAO dao;
	@Before
	public void init(){
		String config  = "mybatis-spring.xml";
		ApplicationContext ac=
			new ClassPathXmlApplicationContext(config);
		dao = ac.getBean("deptDAO",DeptDAO.class);	
	}
	@Test
	public void test1(){
		List<Dept> depts = dao.findAll();
		System.out.println(depts);
	}
}
