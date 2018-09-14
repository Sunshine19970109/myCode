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
		//创建SqlSessionFactoryBuidler对象
		SqlSessionFactoryBuilder ssfb = 
				new SqlSessionFactoryBuilder();
		//创建SqlSessionFactory
		SqlSessionFactory ssf = 
				ssfb.build(TestCase.class.
				getClassLoader().
				getResourceAsStream(config));
		//获得SqlSession对象
		SqlSession session = 
				ssf.openSession();
		Employee e = new Employee();
		e.setName("Eric");
		e.setAge(33);
		//调用SqlSession对象的方法访问数据库
		session.insert("test.save", e);
		/*
		 * ps.setString(1,e.getName())
		 */
		//添加，修改，删除都需要提交事务
		session.commit();
		//关闭SqlSession
		session.close();
	}
}
