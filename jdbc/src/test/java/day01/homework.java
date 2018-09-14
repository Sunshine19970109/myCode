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
 * D. JDBC�ṩ�˶�Java����Ա��
 * ���ݿ⳧�̼��������м�����̵�API��
 * 
 * 2 ����JDBC��ԭ��
	JDBCд�������ӿڣ��ò�ͬ�ĳ�����ʵ������ӿڣ�
	ʵ���˶Բ�ͬ�����ݿ�Ĳ���
	
	JDBC(Java DataBase Connectivity java���ݿ�����)
	��һ������ִ��SQL����Java API,����Ϊ���ֹ�ϵ���ݿ�
	�ṩͳһ���ʣ�����һ����Java���Ա�д����ͽӿ����
	JDBCͨ����׼(һϵ�нӿ�)�����˷������ݿ��ͨ��API,��ͬ�����ݿ�
	���̸��ݸ������ݿ���ص��ṩ�˶�JDBC��ʵ��(ʵ����)
	
	
	A.JDBC����Oracle���ݿ��URLΪjdbc:oracle:thin:@<������>:<�˿ں�(Ĭ��1521)>:<ʵ����>
	D:JDBC����MySql���ݿ��URLΪjdbc:mysql://<������>:<�˿ں�(Ĭ��3306)>/<���ݿ���>
	
	1.java.sql.SQLException:������Ч
	��ѯ�Ӿ�����������⣬���߻�ȡ�Ӿ������������
	2.java.sql.SQLException:ORA-00911����Ч�ַ�
	SQL�����﷨����
	3.java.sql.SQLException:�޷�ת��Ϊ�ڲ���ʾ
	3.ȡ���������ʱ��get***����ʹ�ò�����
 */
	/**
	 * ������Ҫ��ʹ��JDBC����Oracle���ݿ⣬
	 * ��ѯdept������в��ŵ�ID�����������Լ��������ڵء�
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
	 * ���Բ���DBTool���ߵ�oracle����
	 * 1 ����properties����
	 * 2 ���������ļ�
	 * 		����.class.��ȡ�������.��ȡ��Դת��Ϊ��
	 * 3 ��ȡ���Ӳ���
	 * 4 ע������
	 * 5 ��ȡ���Ӷ���
	 * 6 �ر����Ӷ���
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
			//ע������Class.forName(driver)
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
			throw new RuntimeException("��ȡ�����ļ�ʧ��",e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("ע����������ʧ��",e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ȡ���Ӷ���ʧ��",e);
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("���ӹر�ʧ��",e);
				}
			}
		}
		
		
	}
}


















