package cn.com.ysfj.service.Impl;

import java.sql.SQLException;
import java.util.List;

import cn.com.ysfj.dao.IUserMapper;
import cn.com.ysfj.dao.Impl.UserMapper;
import cn.com.ysfj.entity.User;
import cn.com.ysfj.service.IUserService;

public class UserService implements IUserService {
	private static IUserMapper mapper = mapper = new UserMapper();
	public List<User> findAll() throws SQLException {
		return mapper.selectAll();
	}
	public void deleteById(Integer id) throws SQLException {
		mapper.deleteUser(id);
	}
	public void deleteUsers(Integer[] ids) throws SQLException {
		mapper.deleteUsers(ids);
	}
	public List<User> selectByName(String name) throws SQLException {		
		return mapper.selectByName(name);
	}
}
