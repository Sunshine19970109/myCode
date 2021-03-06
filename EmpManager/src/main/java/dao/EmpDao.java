package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import entity.Emp;

public class EmpDao implements Serializable{
	public List<Emp> findAll(){
		//模拟查询所有的员工
		List<Emp> list = new ArrayList<Emp>();
		Emp e1 = new Emp();
		e1.setEmpno(1);
		e1.setEname("唐僧");
		e1.setJob("取经");
		e1.setSal(5000.0);
		list.add(e1);
		Emp e2 = new Emp();
		e2.setEmpno(2);
		e2.setEname("悟空");
		e2.setJob("大师兄");
		e2.setSal(5500.0);
		list.add(e2);
		Emp e3 = new Emp();
		e3.setEmpno(3);
		e3.setEname("八戒");
		e3.setJob("取经");
		e3.setSal(6000.0);
		list.add(e3);
		Emp e4 = new Emp();
		e4.setEmpno(1);
		e4.setEname("沙僧");
		e4.setJob("取经");
		e4.setSal(9000.0);
		list.add(e4);
		
		return list;
	}
	
	public void save(Emp e){
		System.out.println(
				"增加员工"+e.getEname());
	}
}




















