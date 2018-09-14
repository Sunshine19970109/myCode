package test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.netctoss.dao.AdminDAO;
import cn.tedu.netctoss.dao.CostDao;
import cn.tedu.netctoss.dao.CostDaoImpl;
import cn.tedu.netctoss.entity.Admin;
import cn.tedu.netctoss.entity.Cost;
import cn.tedu.netctoss.service.LoginService;
import cn.tedu.netctoss.service.LoginServiceImpl;

public class TestCase {
	@Test
	//�������ӳ�
	public void test1() throws SQLException{
		String config="spring-mvc.xml";
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext(config);
		/*
		 * DataSource��һ���ӿڣ�
		 * BasicDataSource��һ��ʵ���˸ýӿڵ�
		 * �����ࡣ
		 */
		DataSource ds = ac.getBean("ds",DataSource.class);
		System.out.println(ds.getConnection());
	}
	@Test
	//���Գ־ò�
	public void test2(){
		String config="spring-mvc.xml";
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext(config);
		//��ȡdao����
		AdminDAO aDAO = ac.getBean
				("adminDAO",AdminDAO.class);
		Admin a = aDAO.findByAdminCode("caocao");
		System.out.println(a);
	}
	@Test
	//����  ҵ���
	public void test3() throws SQLException{
		String config="spring-mvc.xml";
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext(config);
		LoginService service =
				ac.getBean("loginService",LoginServiceImpl.class);
		Admin admin  = service.checkLogin("caocao", "123");
		System.out.println(admin);
	}
	@Test
	//����  �־ò�
	public void test4(){
		String config="spring-mvc.xml";
		ApplicationContext ac = 
				new ClassPathXmlApplicationContext(config);
		CostDao dao = ac.getBean("costDAO",CostDaoImpl.class);
		List<Cost> costs = dao.findAllCost();
		for (Cost cost : costs) {
			System.out.println(cost);
		}
	}
}
