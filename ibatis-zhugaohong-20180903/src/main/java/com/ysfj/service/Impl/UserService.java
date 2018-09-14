package com.ysfj.service.Impl;

import java.sql.SQLException;
import java.util.List;

import com.ysfj.dao.IUserDAO;
import com.ysfj.dao.Impl.UserDAO;
import com.ysfj.entity.User;
import com.ysfj.service.IUserService;

public class UserService implements IUserService {
	private IUserDAO dao=null;
	public UserService() {
		dao = new UserDAO();
	}
	public List<User> findAll() throws SQLException {
		
		return dao.selectAll();
	}

	public void deleteUser(Integer id) throws SQLException {
		dao.deleteUser(id);
	}

}
