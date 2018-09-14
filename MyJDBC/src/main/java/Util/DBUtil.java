package Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * ���ӳصĽӿ���DataSource,
 * DBCP��ʵ������BasicDataSource
 * 1.��Dept���в���һ����¼��
 * ����Ϊ��deptno��dname��loc��������ݷֱ�
 * Ϊ50��"developer"�� "Beijing"��
 * 
 * 1 ���û���---�޸�set.xml�ļ�������pom.xml--����jar��
 * 2 �������ԣ�������̬����ز�������Դ
 * 3 ����Properties���󣬶�ȡdb.properties�ļ�,����BasicDataSource����
 * 4 ��ȡ������ע������--��ȡ����
 * 5 ����Connection ���󣬻�ȡPreparedStatement����
 * 6 дSQL��䣬Ϊ������ֵ���õ������
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
	//��ȡ����
	public static Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
	//�黹����
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





























