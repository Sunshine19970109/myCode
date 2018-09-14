package test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.ysfj.dao.IUserDAO;
import com.ysfj.dao.Impl.UserDAO;
import com.ysfj.entity.User;

public class TestUserDAO {
	@Test
	public void testSelectAll() throws SQLException{
		IUserDAO dao = new UserDAO();
		List<User> list = dao.selectAll();
		for (User user : list) {
			System.out.println(user);
		}
	}
	@Test
	public void testDeleteUser() throws SQLException{
		IUserDAO dao = new UserDAO();
		dao.deleteUser(52);
	}
}
