package TestDay02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import util.DBUtil;

public class TestDay02 {
	
	/**
	 * ����DBUtil�ķ���
	 */
	@Test
	public void test1(){
		//�������������Ĳ�ѯ������
		int empno = 4;
		
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			System.out.println(conn);
			Statement amt = conn.createStatement();
			String sql = "SELECT * FROM emps"+
			" where empno>"+empno;
			ResultSet rs = amt.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getString("empno"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}	
	}
	
	/**
	 *���ʹ��PSִ��DML 
	 */
	@Test
	public void test2(){
		//����ҳ�洫����޸Ĳ�����
		int empno = 1;
		String ename = "������";
		
		//��������
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			//����PS���󣬲��������̷���SQL
			String sql = "UPDATE emps SET ename=?"+
			" WHERE empno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//������?��ֵ
			//ps.set����(?�����,?��ֵ)
			ps.setString(1, ename);
			ps.setInt(2, empno);
			
			//�����ݿⷢ�Ͳ������������ݿ�ִ��SQL
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	
	/**
	 * ���ʹ��PSִ��DQL
	 */
	@Test
	public void test3(){
		//����ҳ�洫���ѯ������
		double sal = 6000.0;
		Connection conn = null; 
		try {
			String sql = "SELECT * FROM emps "
					+ "WHERE sal>?";
			conn = DBUtil.getConnection();
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setDouble(1, sal);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int empno = Integer.parseInt(rs.getString("empno"));
				String ename = rs.getString("ename");
				int mgr = Integer.parseInt(rs.getString("mgr"));
				String hiredate = rs.getString("hiredate");
				double salary = Double.parseDouble(rs.getString("sal"));
				double comm = Double.parseDouble(rs.getString("comm"));
				int deptno = Integer.parseInt(rs.getString("deptno"));
				System.out.println(empno+" "+ename+" "+mgr+
						" "+hiredate+" "+salary
						+" "+comm+" "+deptno);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ʹ��PSִ�в�ѯ��䣬�����ܷ����
	 * ע�빥��
	 * ָ����ʵ����һ������
	 */
	@Test
	public void test4(){
		//����ҳ�洫��ĵ�¼������:
		String username = "zhangsan";
		String password = "a' or 'b'='b";
		
		Connection conn = null; 
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM users "
					+ "WHERE username = ? "
					+ "AND password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("��¼�ɹ�");
			} else {
				System.out.println("��¼ʧ��");
			}
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
	 * ResultSetMetaDat��ʾ
	 */
	@Test
	public void test5(){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM emps "
					+ "ORDER BY empno";
			Statement smt = conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			//��ȡ�����Ԫ����
			ResultSetMetaData md= rs.getMetaData();
			//Ԫ�����з�װ�˽������������Ϣ
			System.out.println(md.getColumnCount());
			System.out.println(md.getColumnTypeName(2));
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
	 * ģ��ת��ҵ��
	 * ǰ��:
	 * 	�����û��Ѿ���¼������,
	 * �����������տ���˺ţ��Լ�Ҫת�˵Ľ�
	 * 
	 * ����:
	 * 	 1 ��ѯ�����˺ţ���������
	 * 	 2 ��ѯ�տ��˺ŶԲ���
	 *   3 �޸ĸ��������-N
	 *   4 �޸��տ������+N
	 *   
	 * ע��:ת����һ��������ҵ��Ҫʹ��һ�����ӣ�
	 * ����ֻ��һ������
	 */
	@Test
	public void test6(){
		//�����û���¼���˺���
		String payId  = "00001";
		//�տ���˺�
		String recId = "00002";
		//ת�˵Ľ��
		double mny = 1000.0;
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			
			//ȡ���Զ��ύ����
			conn.setAutoCommit(false);
			
			
			//��ѯ�����˺ţ���������
			String sql = "SELECT * FROM accounts WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, payId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			double money = rs.getDouble("money");
			if (money<mny) {
				System.out.println("����");
				return;
			}
			
			//��ѯ�տ��˺ŶԲ���
			String sql2 = "SELECT * FROM accounts WHERE id = ?";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setString(1, recId);
			double recMoney = 0.0;
			ResultSet rs2 = ps2.executeQuery();
			if (!rs2.next()) {
				System.out.println("�տ��˺Ŵ���");
				return;
			}else{
				recMoney = rs2.getDouble("money");
			}
			
			//�޸ĸ��������-N
			String sql3 = "UPDATE accounts SET "
					+ "money=? WHERE id = ?";
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.setDouble(1,money-mny);
			ps3.setString(2,payId);
			ps3.executeUpdate();
			
			
			//�޸��տ������+N
			String sql4 = "UPDATE accounts SET "
					+ "money =? WHERE id = ?";
			PreparedStatement ps4 = conn.prepareStatement(sql4);
			ps4.setDouble(1, recMoney+mny);
			ps4.setString(2, recId);
			ps4.executeUpdate();
			/*
			 * ���û���ύҲû�лع���������ݾ�������
			 * ˭���鲻�ˣ�Ҳ�ò���
			 */
			//�ύ����
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			//�ع�����
			DBUtil.rollback(conn);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}





































