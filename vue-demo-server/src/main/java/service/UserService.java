package service;

import java.util.List;

import entity.User;

public interface UserService {
	/**
	 * 根据姓名查询用户
	 * @param name
	 * @return
	 */
	User login(String name,String password);
	/**
	 * 查找所有的用户
	 */
	List<User> findAll();
}
