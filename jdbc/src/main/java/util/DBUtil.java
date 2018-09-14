package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

public class DBUtil {

	/**
	 * ���ӳض�����DBCP�ṩ
	 */
	private static BasicDataSource ds;
	static{
		Properties p = new Properties();
		try {
			/*
			 * ΪʲôҪ��DBUtil��properties�ļ�
			 * ��Ϊ�����������Լ������Ƚ��ȶ�һ��
			 */
			p.load(DBUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			//��ȡ����
			String driver = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pwd = p.getProperty("pwd");
			String initsize = p.getProperty("initsize");
			String maxsize = p.getProperty("maxsize");
			//�������ӳ�
			ds  = new BasicDataSource();
			//���ò���
			//���ӳػ�ʹ���������ע������
			ds.setDriverClassName(driver);
			//ʹ��������������������
			ds.setUrl(url);
			ds.setUsername(user);
			ds.setPassword(pwd);
			//ʹ������������������--�����û���Ĭ��ֵ
			ds.setInitialSize(Integer.parseInt(initsize));
			ds.setMaxActive(new Integer(maxsize));
			
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
	@Test
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
}











