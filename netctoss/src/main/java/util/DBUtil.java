package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;


public class DBUtil {

	/**
	 * 连接池对象由DBCP提供
	 */
	private static BasicDataSource ds;
	static{
		Properties p = new Properties();
		try {
			//p加载配置文件
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			//创建ds,设置参数
			ds = new BasicDataSource();
			ds.setUrl(p.getProperty("url"));
			ds.setDriverClassName(p.getProperty("driver"));
			ds.setUsername(p.getProperty("user"));
			ds.setPassword(p.getProperty("pwd"));
			ds.setInitialSize(Integer.parseInt(p.getProperty("initsize")));
			ds.setMaxActive(Integer.parseInt(p.getProperty("maxsize")));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("加载db.properties文件失败",e);
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	/**
	 * 由连接池创建的连接，连接的close方法
	 * 被连接池重写了，变为归还连接的逻辑，
	 * 即:连接池会将连接的状态设置为空闲，
	 * 并清空连接中所包含的任何数据
	 * @param conn
	 */
	public static void close(Connection conn){
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				//Runtime是一个单词，不是两个
				throw new RuntimeException("归还连接失败",e);
			}
		}
	}
	/**
	 * 回顾事务
	 */
	
	public static void rollback(Connection conn){
		if (conn!=null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("回滚事务失败",e);
			}
		}
	}
	
	
	/*
	 * 测试
	 * */
	public static void main(String[] args) throws Exception {
		Connection conn =
				DBUtil.getConnection();
		System.out.println(conn);
		DBUtil.close(conn);
	}
}











