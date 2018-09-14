package dao;

import java.util.List;
import java.util.Map;

import entity.Emp;
import entity.Employee;

/**
 * Mappӳ����
 * @author dell
 *
 */
public interface EmployeeDAO {
	public void save(Employee e);
	public List<Employee> findAll();
	public Employee findById(int id);
	public void modify(Employee e);
	public void delete(int id);
	public Map findById2(int id);
	Emp findById3 (int id);
}





















