package cn.com.ysfj.dao;

import java.sql.SQLException;
import java.util.List;

import cn.com.ysfj.entity.User;

public interface IUserMapper {
	/**
	 * ����id��ѯ�û�
	 * @param id
	 * @return
	 */
	User selectById(Integer id) throws SQLException;
	/**
	 * ��ѯ�����û�
	 */
	List<User> selectAll() throws SQLException;
	/**
	 * ɾ��
	 */
	void deleteUser(Integer id) throws SQLException;
	/**
	 * ����ɾ��
	 */
	void deleteUsers(Integer[] ids) throws SQLException;
	/**
	 * ����û�
	 */
	void insertUser(User user) throws SQLException;
	/*
	 * ����������ѯ�û�
	 */
	List<User> selectByName(String name)throws SQLException;
}
