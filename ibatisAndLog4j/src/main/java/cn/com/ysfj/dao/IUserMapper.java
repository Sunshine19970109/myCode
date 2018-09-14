package cn.com.ysfj.dao;

import java.sql.SQLException;
import java.util.List;

import cn.com.ysfj.entity.User;

public interface IUserMapper {
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	User selectById(Integer id) throws SQLException;
	/**
	 * 查询所有用户
	 */
	List<User> selectAll() throws SQLException;
	/**
	 * 删除
	 */
	void deleteUser(Integer id) throws SQLException;
	/**
	 * 批量删除
	 */
	void deleteUsers(Integer[] ids) throws SQLException;
	/**
	 * 添加用户
	 */
	void insertUser(User user) throws SQLException;
	/*
	 * 根据姓名查询用户
	 */
	List<User> selectByName(String name)throws SQLException;
}
