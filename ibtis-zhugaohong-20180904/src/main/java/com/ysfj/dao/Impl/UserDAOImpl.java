package com.ysfj.dao.Impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ysfj.dao.UserDAO;
import com.ysfj.entity.User;

public class UserDAOImpl implements UserDAO {
	private static SqlMapClient client =null;
	static{
		try {
			Reader reader = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			client = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void insertUser(User user) throws SQLException{
		client.insert("insertUser",user);
	}

}
