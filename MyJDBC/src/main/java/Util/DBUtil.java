package Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * 连接池的接口是DataSource,
 * DBCP的实现类是BasicDataSource
 * 1.向Dept表中插入一条记录。
 * 其中为列deptno、dname、loc插入的数据分别
 * 为50、"developer"、 "Beijing"。
 * 
 * 1 配置环境---修改set.xml文件，配置pom.xml--下载jar包
 * 2 创建属性，创建静态块加载并处理资源
 * 3 创建Properties对象，读取db.properties文件,创建BasicDataSource对象
 * 4 读取参数，注册驱动--获取连接
 * 5 创建Connection 对象，获取PreparedStatement对象
 * 6 写SQL语句，为参数赋值，得到结果集
 */
public class DBUtil {
	private static BasicDataSource ds;
	static{
		Properties p = new Properties();
		ds = new BasicDataSource();
		try {
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pwd = p.getProperty("pwd");
			String initsize = p.getProperty("initsize");
			String maxsize = p.getProperty("maxsize");
			ds.setDriverClassName(driver);
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(pwd);
			ds.setInitialSize(Integer.parseInt(initsize));
			ds.setMaxActive(Integer.parseInt(maxsize));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//获取连接
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	//归还连接
	public static void close(Connection conn){
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}





























