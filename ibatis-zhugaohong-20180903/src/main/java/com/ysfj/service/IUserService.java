package com.ysfj.service;

import java.sql.SQLException;
import java.util.List;

import com.ysfj.entity.User;

public interface IUserService {
	/**
	 * 查询所有用户
	 * @return
	 * @throws SQLException
	 */
	List<User> findAll()throws SQLException;
	/**
	 * 根据ID删除用户
	 */
	void deleteUser(Integer id)throws SQLException;
}
