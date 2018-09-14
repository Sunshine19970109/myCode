package test;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.UserDAO;
import entity.User;

public class TestUser {
	private UserDAO dao;
	private AbstractApplicationContext ac;
	@Before
	public void init(){
		System.out.println("init");
		ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		dao = (UserDAO) ac.getBean("userDAOImpl", UserDAO.class);
	}
	@After
	public void close(){
		ac.close();
	}
	@Test
	public void testSelectByName(){
		ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		dao = (UserDAO) ac.getBean("userDAOImpl", UserDAO.class);
		User user = dao.selectByName("sun");
		System.out.println(user);
	}
	@Test
	public void testSelectAll(){
		List<User> users = dao.selectAll();
		for (User user : users) {
			System.out.println(user);
		}
	}
}