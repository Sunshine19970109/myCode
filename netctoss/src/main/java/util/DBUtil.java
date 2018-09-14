package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;


public class DBUtil {

	/**
	 * ���ӳض�����DBCP�ṩ
	 */
	private static BasicDataSource ds;
	static{
		Properties p = new Properties();
		try {
			//p���������ļ�
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			//����ds,���ò���
			ds = new BasicDataSource();
			ds.setUrl(p.getProperty("url"));
			ds.setDriverClassName(p.getProperty("driver"));
			ds.setUsername(p.getProperty("user"));
			ds.setPassword(p.getProperty("pwd"));
			ds.setInitialSize(Integer.parseInt(p.getProperty("initsize")));
			ds.setMaxActive(Integer.parseInt(p.getProperty("maxsize")));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("����db.properties�ļ�ʧ��",e);
		}
	}
	
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	
	/**
	 * �����ӳش��������ӣ����ӵ�close����
	 * �����ӳ���д�ˣ���Ϊ�黹���ӵ��߼���
	 * ��:���ӳػὫ���ӵ�״̬����Ϊ���У�
	 * ��������������������κ�����
	 * @param conn
	 */
	public static void close(Connection conn){
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				//Runtime��һ�����ʣ���������
				throw new RuntimeException("�黹����ʧ��",e);
			}
		}
	}
	/**
	 * �ع�����
	 */
	
	public static void rollback(Connection conn){
		if (conn!=null) {
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�ع�����ʧ��",e);
			}
		}
	}
	
	
	/*
	 * ����
	 * */
	public static void main(String[] args) throws Exception {
		Connection conn =
				DBUtil.getConnection();
		System.out.println(conn);
		DBUtil.close(conn);
	}
}











