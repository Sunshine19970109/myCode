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
	 * 1.向Dept表中插入一条记录。其中为列deptno、dname、loc插入的数据分别为50、"developer"、 "Beijing"。
	 */
	@Test
	public void test1(){
		//获取连接
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
	 * 2.更新部门ID为50的部门所在地为“ShangHai”。
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
	 * 使用Statement实现查询指定姓名的员工的工资，并测试姓名为“CLARK”的员工工资，
	 * 以及姓名为“a' OR 'b'='b”的员工工资。
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
	 * .使用PreparedStatement实现查询指定姓名的员工的工资，并测试姓名为“CLARK”的员工工资，
	 * 以及姓名为“a' OR 'b'='b”的员工工资。
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



















