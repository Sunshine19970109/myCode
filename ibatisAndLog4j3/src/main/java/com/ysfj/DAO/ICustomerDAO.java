package com.ysfj.DAO;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.ysfj.entity.Customer;
import com.ysfj.entity.QueryConditionArray;
import com.ysfj.entity.QueryConditionList;

public interface ICustomerDAO {
	/**
	 * 根据姓名，创建日期，id范围查询用户
	 * @param name--可以存在也可以不存在
	 * @param createdDate--可以有也可以没有
	 * @param ids--可以有也可以没有
	 * @return
	 * @throws SQLException
	 */
	List<Customer> selectByNameAndCreatedDate(
			String name,Date createdDate,Integer[] ids) throws SQLException;
	/**
	 * 插入客户
	 */
	void insertCustomer(Customer customer) throws SQLException;
	/**
	 * 根据id枚举查询用户--Array
	 */
	List<Customer> selectByIds(QueryConditionArray array) throws SQLException;
	/**
	 * 根据id枚举查询用户--List
	 */
	List<Customer> selectByIdsList(QueryConditionList list) throws SQLException;
}
