package test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import entity.Employee;

public class TestCase {
	@Test
	public void test(){
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
		SqlSession session = 
				ssf.openSession();
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
}
