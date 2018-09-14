package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 加载配置文件
 * @author TeduJAVA
 *
 */
public class DBTool {
	private static String driver;
	private static String url;
	private static String user;
	private static String pwd;
	static{
		Properties p = new Properties();
		try {
			
			//加载配置文件
			p.load(DBTool.class.getClassLoader().getResourceAsStream("db.properties"));
			
			//读取连接参数
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			user = p.getProperty("user");
			pwd = p.getProperty("pwd");
			
			//注册驱动
			Class.forName(driver);
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException
			("加载db.properties失败",e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException
			("找不到这个驱动",e);
		}
	}
	/**
	 * 封装关闭连接操作
	 * RuntimeException是可以抛出，也可以不抛出的
	 * @param conn
	 */
	public static void close(Connection conn){
		if (conn!=null) {
			try {
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException
				("关闭连接失败",e);
			}
		}
	}
	
	/**
	 * 封装连接对象
	 * @return
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		/*
		 * 为什么直接throws抛出，而不是try catch？
		 * 强制调用者try Catch 这样会提醒他想起
		 * finally里面关闭连接
		 */
		return DriverManager.getConnection(url,user,pwd);
	}
}
