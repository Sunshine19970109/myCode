package dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import entity.Dept;
@Repository("deptDAO")
public class DeptDAOImpl implements DeptDAO {
	@Resource(name="sst")
	private SqlSessionTemplate sst;
	public void add(Dept d) {
		sst.insert("insert", d);
	}

	public List<Dept> findAll() {
		return sst.selectList("findAll");
	}

	public Dept findById(int id) {
		return sst.selectOne("findById", id);
	}

	public void update(Dept d) {
		sst.update("update", d);
	}

	public void delete(int id) {
		sst.delete("delete",id);
	}

}
