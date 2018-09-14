package day01;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.junit.Test;

import util.DBTool;

public class homework {
/*
 * D. JDBC提供了对Java程序员，
 * 数据库厂商及第三方中间件厂商的API。
 * 
 * 2 简述JDBC的原理
	JDBC写出驱动接口，让不同的厂家来实现这个接口，
	实现了对不同的数据库的操作
	
	JDBC(Java DataBase Connectivity java数据库连接)
	是一种用于执行SQL语句的Java API,可以为多种关系数据库
	提供统一访问，它由一组用Java语言编写的类和接口组成
	JDBC通过标准(一系列接口)定义了访问数据库的通用API,不同的数据库
	厂商根据各自数据库的特点提供了对JDBC的实现(实现类)
	
	
	A.JDBC连接Oracle数据库的URL为jdbc:oracle:thin:@<主机名>:<端口号(默认1521)>:<实例名>
	D:JDBC连接MySql数据库的URL为jdbc:mysql://<主机名>:<端口号(默认3306)>/<数据库名>
	
	1.java.sql.SQLException:列名无效
	查询子句的列名有问题，或者获取子句的列名有问题
	2.java.sql.SQLException:ORA-00911：无效字符
	SQL语句的语法不对
	3.java.sql.SQLException:无法转换为内部表示
	3.取结果集数据时，get***方法使用不当。
 */
	/**
	 * 本案例要求使用JDBC连接Oracle数据库，
	 * 查询dept表的所有部门的ID、部门名称以及部门所在地。
	 */
	@Test
	public void test3(){
		Connection conn = null;
		try {
			conn = DBTool.getConnection();
			Statement stm = conn.createStatement();
			String sql = "SELECT deptno ,dname,loc   FROM dept";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptno+"  "+dname+"  "+loc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 测试不用DBTool工具的oracle连接
	 * 1 创建properties对象
	 * 2 加载配置文件
	 * 		类名.class.获取类加载器.获取资源转化为流
	 * 3 获取连接参数
	 * 4 注册驱动
	 * 5 获取连接对象
	 * 6 关闭连接对象
	 */
	@Test
	public void test(){
		Properties p = new Properties();
		Connection conn = null;
		try {
			p.load(homework.class.getClassLoader().getResourceAsStream("db.properties"));
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pwd = p.getProperty("pwd");
			//注册驱动Class.forName(driver)
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
			Statement stm = conn.createStatement();
			String sql = "SELECT deptno ,dname,loc   FROM dept";
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				System.out.println(deptno+"--  "+dname+"  "+loc);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("获取配置文件失败",e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("注册驱动加载失败",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("获取连接对象失败",e);
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("连接关闭失败",e);
				}
			}
		}
		
		
	}
}


















