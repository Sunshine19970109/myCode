package dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import dao.UserDAO;
import entity.User;
@Repository
public class UserDAOImpl implements UserDAO {
	@Resource
	private SqlMapClientTemplate sqlMapClientTemplate;
	public User selectByName(String name) {
		return (User)sqlMapClientTemplate.queryForObject("selectByName", name);
	}
	public List<User> selectAll() {
		return sqlMapClientTemplate.queryForList("selectAll");
	}

}
