package com.ysfj.DAO.Impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;
import com.ysfj.DAO.ICustomerDAO;
import com.ysfj.entity.Customer;
import com.ysfj.entity.QueryConditionArray;
import com.ysfj.entity.QueryConditionList;

public class CustomerDAO  implements ICustomerDAO {
	private static SqlMapClient client = null;
	static{
		try {
			Reader reader = Resources.getResourceAsReader("config/SQLMapConfig.xml");
			System.out.println(reader.getClass());
			client = SqlMapClientBuilder.buildSqlMapClient(reader);
			System.out.println(client);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public List<Customer> selectByNameAndCreatedDate(String name, Date createdDate, Integer[] ids) throws SQLException {
		Map map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("createdDate", createdDate);
		map.put("ids", ids);
		return client.queryForList("selectByNameAndCreatedDate",map);
	}
	public void insertCustomer(Customer customer) throws SQLException {
		client.insert("insertCustomer", customer);
	}
	public List<Customer> selectByIds(QueryConditionArray array) throws SQLException {
		return client.queryForList("selectByIds", array);
	}
	public List<Customer> selectByIdsList(QueryConditionList list) throws SQLException {
		return client.queryForList("selectByIdsList", list);
	}

}
