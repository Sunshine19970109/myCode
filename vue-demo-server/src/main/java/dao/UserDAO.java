package dao;

import java.util.List;

import entity.User;

public interface UserDAO {
	/**
	 * 根据名字查询用户
	 * @param name
	 * @return
	 */
	User selectByName(String name);
	/**
	 * 查询所有用户
	 */
	List<User> selectAll();
}
