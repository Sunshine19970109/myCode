package com.ysfj.dao;

import java.sql.SQLException;

import com.ysfj.entity.User;

public interface UserDAO {
	/**
	 * �����û�
	 * @param user
	 */
	void insertUser(User user)throws SQLException;
}
