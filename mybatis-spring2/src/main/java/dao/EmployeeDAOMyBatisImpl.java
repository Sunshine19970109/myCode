package dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import entity.Emp;
import entity.Employee;
@Repository("empDAO")
public class EmployeeDAOMyBatisImpl implements EmployeeDAO {
	@Autowired
	@Qualifier("sst")
	private SqlSessionTemplate sst;
	/*
	 * 这里如果用@Resource就需要javax.annotation这个包
	 * 不用考虑提交事务和关闭SqlSession
	 * (non-Javadoc)
	 * @see dao.EmployeeDAO#save(entity.Employee)
	 */
	public void save(Employee e) {
		sst.insert(
			"dao.save", e);
	}

	public List<Employee> findAll() {
		return sst.selectList("dao.findAll");
	}

	public Employee findById(int id) {
		return sst.selectOne("findById", id);
	}

	public void modify(Employee e) {
		sst.update("modify", e);
	}

	public void delete(int id) {
		sst.delete("delete",id);
	}

	public Map findById2(int id) {
		return sst.selectOne(
			"findById2",id);
	}

	public Emp findById3(int id) {
		return sst.selectOne(
			"findById3", id);
	}

}
