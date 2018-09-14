package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import dao.EmployeeDAO;
import entity.Emp;
import entity.Employee;

public class TestCase {
	private SqlSession session;
	@Before
	public void init(){
		SqlSessionFactoryBuilder ssfb = 
				new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = ssfb.build(
				TestCase.class.getClassLoader().
				getResourceAsStream("SqlMapConfig.xml"));
		session = ssf.openSession();
	}
	@Test
	public void test1(){
		EmployeeDAO dao=
		session.getMapper(EmployeeDAO.class);
		Employee e = new Employee();
		e.setName("Sally");
		e.setAge(22);
		dao.save(e);
		session.commit();
		session.close();
	}
	@Test
	public void test2(){
		EmployeeDAO dao = 
			session.getMapper(EmployeeDAO.class);
		List<Employee>emps = dao.findAll();
		System.out.println(emps);
		session.close();
	}
	@Test
	public void test3(){
		EmployeeDAO dao = 
			session.getMapper(EmployeeDAO.class);
		Employee e = dao.findById(5);
		System.out.println(e);
		session.close();
	}
	@Test
	//≤‚ ‘ modify
	public void test4(){
		EmployeeDAO dao = session.getMapper(EmployeeDAO.class);
		Employee e = dao.findById(5);
		System.out.println(e);
		e.setAge(50);
		e.setName("∆ÎÃÏ¥Û •");
		dao.modify(e);
		session.commit();
		Employee e1 = dao.findById(5);
		System.out.println(e1);
		session.close();
	}
	@Test
	//≤‚ ‘  delete
	public void test5(){
		EmployeeDAO dao = 
			session.getMapper(EmployeeDAO.class);
		dao.delete(5);
		session.commit();
		Employee e = dao.findById(5);
		System.out.println(e);
		session.close();
	}
	@Test
	//≤‚ ‘findById2
	public void test6(){
		EmployeeDAO dao = 
			session.getMapper(EmployeeDAO.class);
		Map e = dao.findById2(21);
		System.out.println(e);
		session.close();
	}
	@Test
	//≤‚ ‘findById3
	public void test7(){
		EmployeeDAO dao = 
			session.getMapper(EmployeeDAO.class);
		Emp e = dao.findById3(21);
		System.out.println(e);
		session.close();
	}
	
}













