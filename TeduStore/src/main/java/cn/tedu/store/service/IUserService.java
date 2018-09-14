package cn.tedu.store.service;

import cn.tedu.store.bean.User;

public interface IUserService {
	/**
	 * 添加用户
	 * @param user
	 */
	void addUser(User user);
	/**
	 * 验证邮箱是否存在
	 * @param email
	 * @return 如果存在返回true
	 * 					如果不存在返回false
	 */
	public boolean checkEmail(String email);
	/**
	 * 验证电话号码是否存在
	 * @param phone
	 * @return 如果存在返回true
	 * 				 如果不存在返回false
	 */
	boolean checkPhone(String phone);
	/**
	 * 验证用户名是否存在
	 * @param username
	 * @return 如果存在就返回true
	 * 				如果不存在就返回false
	 */
	boolean checkUsername(String username);
	/**
	 * 实现登陆功能
	 * @param username
	 * @param password
	 * @return 如果密码和用户名都对就返回User
	 * 					如果没有用户名抛出异常  帐号错误
	 * 					如果密码不对抛出异常   密码不匹配
	 */
	User login(String username,String password);
	/**
	 * 
	 * @param id这里必须从session中获取id
	 * @param oldPassword 页面传入的旧密码
	 * @param newPassword 页面传入的新的密码
	 */
	void changePassword(Integer id,String oldPassword,String newPassword);
	/**
	 * 修改用户信息
	 * @param id
	 * @param username
	 * @param gender
	 * @param email
	 * @param phone
	 */
	void updateUser(Integer id,String username,Integer gender,String email,String phone);
	/**
	 * 通过业务层用ID查找用户
	 * @param id
	 * @return
	 */
	User getUserById(Integer id);
	/**
	 * 修改头像
	 * @param id
	 * @param image
	 */
	void updImage(Integer id,String image);
}
