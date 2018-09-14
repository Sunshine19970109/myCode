package cn.com.ysfj.dao.Impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import cn.com.ysfj.dao.IUserMapper;
import cn.com.ysfj.entity.User;

public class UserMapper implements IUserMapper {
	
	private static  SqlMapClient sqlMapClient =null;
	static {
		try {
			Reader reader = com.ibatis.common.resources.Resources
					.getResourceAsReader("config/SQLMapConfig.xml");
			sqlMapClient = com.ibatis.sqlmap.client.SqlMapClientBuilder
					.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public User selectById(Integer id) throws SQLException  {
		return (User)sqlMapClient.queryForObject("selectById",id);
	}
	public List<User> selectAll() throws SQLException  {
		List<User> users = sqlMapClient.queryForList("selectAll");
		return users;
	}
	
	public void deleteUsers(Integer[] ids) throws SQLException {
		sqlMapClient.delete("deleteUsers",ids);
	}
	public void deleteUser(Integer id) throws SQLException {
		sqlMapClient.delete("deleteUser", id);
	}
	public void insertUser(User user) throws SQLException {
		sqlMapClient.insert("insertUser", user);
	}
	public List<User> selectByName(String name) throws SQLException {
		List<User> list = sqlMapClient.queryForList("selectByName",name);
		return list;
	}
}
