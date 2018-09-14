package day01;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Properties;

import org.junit.Test;

import util.DBTool;
/**
 * Junit
 * 1.允许一个类中的多个方法都能单独执行
 * 2.必须在方法之前加上@Test才能让它单独执行
 * 3.方法必须是公有的，无返回值的，无参的
 * 4.在正式的WEB项目中，代码需要拷贝到服务器里
 * 	 执行，Eclipse在拷贝代码时会被抛弃测试代码，
 *   所以Junit的包将来也会被抛弃，就无需使用maven
 *   来导入这样的包了
 * @author TeduJAVA
 *
 */
/*
 * maven: 可以去doc.tedu.cn文档服务器去找文档
 * 导包失败怎么办?
 * 1 将pom.xml中的代码(<dependency>)删除
 * 2 将下载失败的缓存文件删除(/.m2/repository下)
 * 看Eclipse左边
 */
public class TestDay01 {
	/*
	 *只要在测试方法上面写上@Test就可以单独执行
	 *测试代码的新的方法Junit
	 */
	/**
	 * 如何创建连接
	 * 配置文件key=values标准格式
	 */
	@Test
	public void test1(){
		
		//注册驱动
		try {
			/*
			 * 查找类拷贝类名
			 */
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//创建连接
		Connection conn = null;
		try {
			/*
			 * 主机IP:192.168.1.182
			 * 参数
			 * 1 jdbc:oracle:thin:@主机IP:端口:SID
			 * 2 用户名
			 * 3 口令
			 */
			 conn = 
			DriverManager.getConnection(
			"jdbc:oracle:thin:@localhost:1521:xe",
			"system","tedustudent");
			System.out.println(conn);
		} catch (SQLException e) {
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
	 * 如何读取properties文件
	 * 1 使用java.util.Properties类
	 * 2 它本质上就是Map
	 * 3 它专门用来读取properties文件
	 */
	@Test
	public void test2(){
		Properties p = new Properties();
		try {
			//从classes下去读取配置文件
			/*
			 * 这样做一般不会出错，因为有多个db.properties
			 * 其他方法容易出错
			 */
			p.load(TestDay01.class.getClassLoader()
					.getResourceAsStream("db.properties"));
			//获取值
			String driver = p.getProperty("driver");
			System.out.println(driver);
			/*
			 * 遇到问题:
			 * 首先不用怕
			 * 学会调适
			 */
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 1 测试DBTool.getConnection()方法能不能用
	 * 2 执行insert语句
	 * INSERT INTO emps 
	 * VALUES(emps_seq.NEXTVAL,'唐僧','经理',0,SYSDATE,
	 * 8000,2000,3)
	 * 3 每次执行之后都应该执行一次commit,不然java识别
	 * 不到
	 * 4 写完SQL不要写分号结束
	 */
	
	@Test
	public void test3(){
		Connection conn = null;
		try {
			//创建连接
			conn = DBTool.getConnection();
			System.out.println(conn);
			//创建Statement--可以帮我们执行SQL
			Statement smt = conn.createStatement();
			//SQL
			String sql = 
					"DELETE  FROM emps"+
					" WHERE emps.ename='唐僧'";
			/*
			 *返回增加、修改、删除了几行
			 */
			int rows = smt.executeUpdate(sql);
			System.out.println(rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBTool.close(conn);
		}
	}
	
	/**
	 * 如何执行查询语句?
	 */
	@Test
	public void test4(){
		/*
		 * 1 创建连接
		 * 2 创建statement对象
		 * 3 写sql语句
		 * 4 关闭连接
		 * 5 ctrl + shift +x/y 变大小写
		 */
		Connection conn = null;
		try {
			conn = DBTool.getConnection();
			Statement stm = conn.createStatement();
			String sql = "SELECT * FROM emps"
					+" WHERE deptno = 1 ORDER BY empno";
			//返回的ResultSet是结果集
			//该结果是多行多列的
			/*
			 * 该对象采用迭代器模式设计而来
			 * 迭代器通常使用while遍历
			 */
			ResultSet rs = stm.executeQuery(sql);
			//每次next()就可以读取到下一行数据
			//指向下一行
			while(rs.next()){
				//获取该行的每一列的值
				/*
				 * rs.get类型(字段的序号)
				 * rs.get类型(字段的名字)
				 * 建议使用字段名--因为序号时间长了可能添加字段
				 */
				System.out.println(rs.getInt("empno"));
				System.out.println(rs.getString("ename"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBTool.close(conn);
		}
		
	}
	/**
	 * 测试Update语句
	 */
	@Test
	public void test5(){
		/*
		 * 1 创建连接
		 * 2 创建Statement对象
		 * 3 执行SQL语句
		 * 4 获取并用迭代器遍历ResultSet结果集
		 * 4 关闭连接
		 */
		Connection conn = null;
		try {
			conn = DBTool.getConnection();
			Statement stm = conn.createStatement();
			String sql = "UPDATE emps "
						+" SET ename='悟空' "
						+" WHERE empno = 10 ";
			int rows = stm.executeUpdate(sql);
			System.out.println(rows);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
}




























