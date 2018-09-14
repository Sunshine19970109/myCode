package cn.com.ysfj.service;

import java.sql.SQLException;
import java.util.List;

import cn.com.ysfj.entity.User;

public interface IUserService {
	/**
	 * ��ѯ���е��û�
	 */
	List<User> findAll() throws SQLException ;
	/**
	 * ����IDɾ���û�
	 */
	void deleteById(Integer id) throws SQLException;
	/**
	 * ����ɾ���û�
	 */
	void deleteUsers(Integer[] ids)throws SQLException;
	/**
	 * ʹ������ģ����ѯ�û�
	 */
	List<User> selectByName(String name)throws SQLException;
}
