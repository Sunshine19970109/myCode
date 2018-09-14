package com.ysfj.dao.Impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ysfj.dao.IUserDAO;
import com.ysfj.entity.User;

public class UserDAO implements IUserDAO {
	private static SqlMapClient client = null;
	static{
		try {
			Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			client = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<User> selectAll() throws SQLException {
		return client.queryForList("selectAll");
	}
	public void deleteUser(Integer id) throws SQLException {
		client.delete("deleteUser", id);
	}
	
}
