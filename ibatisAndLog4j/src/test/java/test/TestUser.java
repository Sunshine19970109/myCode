package test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import cn.com.ysfj.dao.IUserMapper;
import cn.com.ysfj.dao.Impl.UserMapper;
import cn.com.ysfj.entity.User;

public class TestUser {
	@Test
	public void testSelectById() throws IOException, SQLException{
		IUserMapper userMapper = new UserMapper();
		User user = userMapper.selectById(25);
		System.out.println(user);
	}
	@Test
	public void testSelectAll() throws IOException, SQLException{
		IUserMapper userMapper = new UserMapper();
		List<User> users = userMapper.selectAll();
		for (User user : users) {
			System.out.println(user);
		}
	}
	@Test
	public void testDeleteUser() throws IOException, SQLException{
		IUserMapper userMapper = new UserMapper();
		userMapper.deleteUser(3);
	}
	@Test
	public void testDeleteUsers() throws IOException, SQLException{
		IUserMapper userMapper = new UserMapper();
		userMapper.deleteUsers(new Integer[]{16,17,18});
	}
	@Test
	public void testInsertUser() throws SQLException{
		IUserMapper userMapper = new UserMapper();
		User user = new User("tom2", "mytom2", "1313105223@163.com", "ÃÏΩÚ –");
		userMapper.insertUser(user);
	}
	@Test
	public void testSelectByName() throws SQLException{
		IUserMapper mapper = new UserMapper();
		List<User> list = mapper.selectByName("sun");
		for (User user : list) {
			System.out.println(user);
		}
	}
}
