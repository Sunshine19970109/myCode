package dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import annotations.MyBatisRepository;
import entity.Dept;
@Repository
@MyBatisRepository
public interface DeptDAO {
	void add(Dept d);
	List<Dept> findAll();
	Dept findById(int id);
	void update(Dept d);
	void delete(int id);
}
