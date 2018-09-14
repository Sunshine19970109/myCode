package com.ysfj.Dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ysfj.entity.User;

public class UserDAO implements IUserDAO {
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
	public Integer insertUser(User user){
		try {
			return	(Integer)sqlMapClient.insert("insertUser",user);
		} catch (Exception e) {
			return 0;
		}
	}
	public List<User> selectAll() throws SQLException {
		
		return sqlMapClient.queryForList("selectAll");
	}
}
