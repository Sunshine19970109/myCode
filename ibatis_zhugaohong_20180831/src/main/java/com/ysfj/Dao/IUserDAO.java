package com.ysfj.Dao;

import java.sql.SQLException;
import java.util.List;

import com.ysfj.entity.User;

public interface IUserDAO {
	/**
	 * �����û�
	 */
	Integer insertUser(User user);
	/**
	 * ��ѯ�����û�
	 * @return
	 * @throws SQLException
	 */
	List<User> selectAll() throws SQLException;
}
