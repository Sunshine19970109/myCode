package com.ysfj.service;

import java.sql.SQLException;
import java.util.List;

import com.ysfj.entity.User;

public interface IUserService {
	/**
	 * ��ѯ�����û�
	 * @return
	 * @throws SQLException
	 */
	List<User> findAll()throws SQLException;
	/**
	 * ����IDɾ���û�
	 */
	void deleteUser(Integer id)throws SQLException;
}
