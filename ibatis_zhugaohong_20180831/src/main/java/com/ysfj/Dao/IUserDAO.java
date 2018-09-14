package com.ysfj.Dao;

import java.sql.SQLException;
import java.util.List;

import com.ysfj.entity.User;

public interface IUserDAO {
	/**
	 * 插入用户
	 */
	Integer insertUser(User user);
	/**
	 * 查询所有用户
	 * @return
	 * @throws SQLException
	 */
	List<User> selectAll() throws SQLException;
}
