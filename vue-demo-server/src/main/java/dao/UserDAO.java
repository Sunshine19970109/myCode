package dao;

import java.util.List;

import entity.User;

public interface UserDAO {
	/**
	 * �������ֲ�ѯ�û�
	 * @param name
	 * @return
	 */
	User selectByName(String name);
	/**
	 * ��ѯ�����û�
	 */
	List<User> selectAll();
}
