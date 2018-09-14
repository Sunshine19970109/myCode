package test;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import entity.Emp;
import entity.Employee;

public class TestCase {
	private SqlSession session;
	@Before
	public void init(){
		String config = "SqlMapConfig.xml";
		//����SqlSessionFactoryBuidler����
		SqlSessionFactoryBuilder ssfb = 
				new SqlSessionFactoryBuilder();
		//����SqlSessionFactory
		SqlSessionFactory ssf = 
				ssfb.build(TestCase.class.
				getClassLoader().
				getResourceAsStream(config));
		//���SqlSession����
		session = 
				ssf.openSession();
	}
	@Test
	public void test(){
		
		Employee e = new Employee();
		e.setName("Eric");
		e.setAge(33);
		//����SqlSession����ķ����������ݿ�
		session.insert("test.save", e);
		/*
		 * ps.setString(1,e.getName())
		 */
		//��ӣ��޸ģ�ɾ������Ҫ�ύ����
		session.commit();
		//�ر�SqlSession
		session.close();
	}
	
	@Test
	public void test2(){
		List<Employee> emps = 
				session.selectList(
				"test.findAll");
		System.out.println(emps);
		//session.close�����ײ��黹
		//connection�����ӳ�
		session.close();
	}
	
	@Test
	public void test3(){
		Employee e = 
				session.selectOne(
				"test.findById",2);
		System.out.println(e);
		session.close();
	}
	
	@Test
	public void test4(){
		Employee e = 
				session.selectOne(
				"test.findById",2);
		System.out.println(e);
		e.setAge(20);
		e.setName("½Ӣ��");
		session.update("modify", e);
		session.commit();
		Employee e2 = 
				session.selectOne(
				"test.findById",2);
		System.out.println(e2);
		session.close();
	}
	
	@Test
	public void test5(){
		session.delete("test.delete", 3);
		session.commit();
		Employee e = 
				session.selectOne(
				"test.findById",3);
		System.out.println(e);
		session.close();
	}
	@Test
	public void test6(){
		Map data = 
				session.selectOne(
				"test.findById2", 5);
		//ע��:oracle���ݿ�Ὣ�ֶ���
		//ͳһ��ɴ�д��ʽ��
		System.out.println(data.get("NAME"));
		session.close();
	}
	@Test
	//����	ʹ��resultMap
	public void test7(){
		Emp emp = session.selectOne(
				"findById3", 5);
		System.out.println(emp);
		session.close();
	}
}















