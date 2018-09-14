package test;

import java.sql.SQLException;

import org.junit.Test;

import cn.com.ysfj.service.Impl.UserService;

public class TestUserService {
	@Test
	public void testFindAll() throws SQLException{
		UserService us = new UserService();
		System.out.println(us.findAll());
	}
	@Test
	public void testUsers()throws SQLException{
		UserService us = new UserService();
		us.deleteUsers(new Integer[]{});
	}
}
