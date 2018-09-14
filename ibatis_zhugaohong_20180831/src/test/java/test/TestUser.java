package test;

import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.ysfj.Dao.IUserDAO;
import com.ysfj.Dao.UserDAO;
import com.ysfj.entity.User;

public class TestUser {
	/*
	 * ����
	 * bean
	 * �����ļ�
	 */
	/**
	 * �����û�
	 * @throws SQLException 
	 */
	@Test
	public void testInsertUser() throws SQLException{
		IUserDAO dao = new UserDAO();
		User user = new User("Tom", "BigTom", "13132105235@163.com",
				"���̸���", new Date());
		Integer result = dao.insertUser(user);
		System.out.println("��� :"+result);
	}
}
