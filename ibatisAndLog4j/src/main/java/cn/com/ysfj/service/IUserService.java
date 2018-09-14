package cn.com.ysfj.service;

import java.sql.SQLException;
import java.util.List;

import cn.com.ysfj.entity.User;

public interface IUserService {
	/**
	 * 查询所有的用户
	 */
	List<User> findAll() throws SQLException ;
	/**
	 * 根据ID删除用户
	 */
	void deleteById(Integer id) throws SQLException;
	/**
	 * 批量删除用户
	 */
	void deleteUsers(Integer[] ids)throws SQLException;
	/**
	 * 使用名字模糊查询用户
	 */
	List<User> selectByName(String name)throws SQLException;
}
