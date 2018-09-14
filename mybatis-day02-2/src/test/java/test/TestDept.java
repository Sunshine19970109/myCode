package test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import entity.Dept;

public class TestDept {
	private SqlSession session;
	@Before
	public void init(){
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = ssfb.build(TestDept.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml"));
		session = ssf.openSession();
	}
	@Test
	public void test1(){
		List<Dept> ds= session.selectList("test1.findAll");
		System.out.println(ds);
		session.close();
	}
	@Test
	public void test2(){
		Dept d = new Dept();
		d.setAddr("����");
		d.setDeptName("����");
		session.insert("test1.add", d);
		session.commit();
		session.close();//��ʹ�ر�Ĭ��Ҳ�ǲ��ύ��
	}
	@Test
	public void test3(){
		Dept d = session.selectOne("test1.findById", 8);
		System.out.println(d);
		session.close();
	}
	@Test
	public void test4(){
		Dept d = session.selectOne("test1.findById", 8);
		System.out.println(d);
		d.setAddr("����");
		session.update("test1.update", d);
		session.commit();
		d = session.selectOne("test1.findById", 8);
		System.out.println(d);
		session.close();
	}
	@Test
	public void test5(){
		session.delete("test1.delete", 8);
		session.commit();
		Dept d = session.selectOne("test1.findById", 8);
		System.out.println(d);
		session.close();
	}
}














