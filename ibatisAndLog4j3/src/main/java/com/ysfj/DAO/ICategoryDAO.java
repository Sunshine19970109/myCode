package com.ysfj.DAO;

import java.sql.SQLException;
import java.util.List;

import com.ysfj.entity.Category;
import com.ysfj.entity.Product;

public interface ICategoryDAO {
	/**
	 * ��ѯ�������Ӧ�����е���Ʒ
	 */
	List<Product> selectAllProduct(Category category)throws SQLException;
}
