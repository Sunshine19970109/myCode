package com.ysfj.dao;

import java.sql.SQLException;
import java.util.List;

import com.ysfj.entity.User;

public interface IUserDAO {
	/**
	 * 查询所有用户
	 */
	List<User> selectAll() throws SQLException;
	/**
	 * 根据ID删除用户
	 */
	void deleteUser(Integer id) throws SQLException;
}
