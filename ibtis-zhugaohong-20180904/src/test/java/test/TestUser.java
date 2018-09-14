package test;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Date;

import org.junit.Test;

import com.ysfj.dao.UserDAO;
import com.ysfj.dao.Impl.UserDAOImpl;
import com.ysfj.entity.User;

public class TestUser {
	@Test
	public void testInsertUser() throws SQLException{
		UserDAO dao = new UserDAOImpl();
		User user = new User("sun", "sunshine",
				"1313210523@163.com", "Ìì½ò", new Date());
		dao.insertUser(user);
	}
}
