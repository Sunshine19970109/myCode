package com.ysfj.dao;

import java.sql.SQLException;
import java.util.List;

import com.ysfj.entity.User;

public interface IUserDAO {
	/**
	 * ��ѯ�����û�
	 */
	List<User> selectAll() throws SQLException;
	/**
	 * ����IDɾ���û�
	 */
	void deleteUser(Integer id) throws SQLException;
}
