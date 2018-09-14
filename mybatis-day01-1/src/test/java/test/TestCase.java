package test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import entity.Employee;

public class TestCase {
	@Test
	public void test1(){
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = ssfb.build(TestCase.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml"));
		SqlSession session = ssf.openSession();
		Employee e = new Employee();
		e.setName("���");
		e.setAge(500);
		/*
		 * �������Ե�˳�򣬱�������ݿ��ֶε�˳��һ��
		 */
		session.insert("test.save",e);
		session.commit();
		session.close();
	}
}
