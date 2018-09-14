package com.ysfj.DAO;

import java.sql.SQLException;
import java.util.List;

import com.ysfj.entity.Category;
import com.ysfj.entity.Product;

public interface ICategoryDAO {
	/**
	 * 查询类别名对应的所有的商品
	 */
	List<Product> selectAllProduct(Category category)throws SQLException;
}
