package com.ysfj.DAO;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.ysfj.entity.Customer;
import com.ysfj.entity.QueryConditionArray;
import com.ysfj.entity.QueryConditionList;

public interface ICustomerDAO {
	/**
	 * �����������������ڣ�id��Χ��ѯ�û�
	 * @param name--���Դ���Ҳ���Բ�����
	 * @param createdDate--������Ҳ����û��
	 * @param ids--������Ҳ����û��
	 * @return
	 * @throws SQLException
	 */
	List<Customer> selectByNameAndCreatedDate(
			String name,Date createdDate,Integer[] ids) throws SQLException;
	/**
	 * ����ͻ�
	 */
	void insertCustomer(Customer customer) throws SQLException;
	/**
	 * ����idö�ٲ�ѯ�û�--Array
	 */
	List<Customer> selectByIds(QueryConditionArray array) throws SQLException;
	/**
	 * ����idö�ٲ�ѯ�û�--List
	 */
	List<Customer> selectByIdsList(QueryConditionList list) throws SQLException;
}
