package service;

import java.util.List;

import entity.User;

public interface UserService {
	/**
	 * ����������ѯ�û�
	 * @param name
	 * @return
	 */
	User login(String name,String password);
	/**
	 * �������е��û�
	 */
	List<User> findAll();
}
