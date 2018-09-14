package com.ysfj.DAO.Impl;

import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.List;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ysfj.DAO.ICategoryDAO;
import com.ysfj.entity.Product;
import com.ysfj.entity.Category;

public class CategoryDAO implements ICategoryDAO {
	private static SqlMapClient client =null;
	static{
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("config/SQLMapConfig.xml");
			client = SqlMapClientBuilder.buildSqlMapClient(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public List<Product> selectAllProduct(Category category) throws SQLException {
		List<Product> pros = 
				client.queryForList("selectAllProduct", category);
		
		return pros;
	}


}
