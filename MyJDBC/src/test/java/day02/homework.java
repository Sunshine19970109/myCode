package day02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import Util.DBUtil;

public class homework {
	/**
	 * 1.��Dept���в���һ����¼������Ϊ��deptno��dname��loc��������ݷֱ�Ϊ50��"developer"�� "Beijing"��
	 */
	@Test
	public void test1(){
		//��ȡ����
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "INSERT INTO dept VALUES"
					+ "(50,'develop','Beijing')";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
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
	/*
	 * 2.���²���IDΪ50�Ĳ������ڵ�Ϊ��ShangHai����
	 */
	@Test
	public void test2(){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "UPDATE  dept "
					+ "SET loc = 'ShangHai' "
					+ "WHERE deptno=50";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
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
	 * ʹ��Statementʵ�ֲ�ѯָ��������Ա���Ĺ��ʣ�����������Ϊ��CLARK����Ա�����ʣ�
	 * �Լ�����Ϊ��a' OR 'b'='b����Ա�����ʡ�
	 */
	@Test
	public void test3(){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			Statement smt = conn.createStatement();
			String sql = "SELECT sal FROM emp WHERE ename='CLARk'";
			String sql1 = "SELECT sal FROM emp WHERE ename='a' OR 'b'='b'";
			ResultSet rs = smt.executeQuery(sql);
			
			rs.next();
			int sal = rs.getInt("sal");
			System.out.println(sal);
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
	 * .ʹ��PreparedStatementʵ�ֲ�ѯָ��������Ա���Ĺ��ʣ�����������Ϊ��CLARK����Ա�����ʣ�
	 * �Լ�����Ϊ��a' OR 'b'='b����Ա�����ʡ�
	 */
	@Test
	public void test4(){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM emp WHERE ename=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "CLARK");
			ResultSet rs = ps.executeQuery();
			rs.next();
			String name = rs.getString("ename");
			int sal = rs.getInt("sal");
			System.out.println(name+" :"+sal);
		} catch (SQLException e) {
			
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



















