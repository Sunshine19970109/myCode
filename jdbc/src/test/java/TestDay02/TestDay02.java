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
	 * 测试DBUtil的方法
	 */
	@Test
	public void test1(){
		//假设浏览器传入的查询条件是
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
	 *如何使用PS执行DML 
	 */
	@Test
	public void test2(){
		//假设页面传入的修改参数是
		int empno = 1;
		String ename = "张三丰";
		
		//创建连接
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			//创建PS对象，并让它立刻发送SQL
			String sql = "UPDATE emps SET ename=?"+
			" WHERE empno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//给参数?赋值
			//ps.set类型(?的序号,?的值)
			ps.setString(1, ename);
			ps.setInt(2, empno);
			
			//向数据库发送参数，并让数据库执行SQL
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	
	/**
	 * 如何使用PS执行DQL
	 */
	@Test
	public void test3(){
		//假设页面传入查询条件是
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
	 * 使用PS执行查询语句，看它能否避免
	 * 注入攻击
	 * 指针其实就是一个变量
	 */
	@Test
	public void test4(){
		//假设页面传入的登录条件是:
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
				System.out.println("登录成功");
			} else {
				System.out.println("登录失败");
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
	 * ResultSetMetaDat演示
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
			//获取结果集元数据
			ResultSetMetaData md= rs.getMetaData();
			//元数据中封装了结果集的描述信息
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
	 * 模拟转账业务
	 * 前提:
	 * 	假设用户已经登录了网银,
	 * 并且输入了收款方的账号，以及要转账的金额。
	 * 
	 * 步骤:
	 * 	 1 查询付款账号，看余额够不够
	 * 	 2 查询收款账号对不对
	 *   3 修改付款余额，金额-N
	 *   4 修改收款余额，金额+N
	 *   
	 * 注意:转账是一个完整的业务，要使用一个连接，
	 * 保障只有一个事物
	 */
	@Test
	public void test6(){
		//假设用户登录的账号是
		String payId  = "00001";
		//收款方的账号
		String recId = "00002";
		//转账的金额
		double mny = 1000.0;
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			
			//取消自动提交事务
			conn.setAutoCommit(false);
			
			
			//查询付款账号，看余额够不够
			String sql = "SELECT * FROM accounts WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, payId);
			ResultSet rs = ps.executeQuery();
			rs.next();
			double money = rs.getDouble("money");
			if (money<mny) {
				System.out.println("余额不足");
				return;
			}
			
			//查询收款账号对不对
			String sql2 = "SELECT * FROM accounts WHERE id = ?";
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			ps2.setString(1, recId);
			double recMoney = 0.0;
			ResultSet rs2 = ps2.executeQuery();
			if (!rs2.next()) {
				System.out.println("收款账号错误");
				return;
			}else{
				recMoney = rs2.getDouble("money");
			}
			
			//修改付款余额，金额-N
			String sql3 = "UPDATE accounts SET "
					+ "money=? WHERE id = ?";
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.setDouble(1,money-mny);
			ps3.setString(2,payId);
			ps3.executeUpdate();
			
			
			//修改收款余额，金额+N
			String sql4 = "UPDATE accounts SET "
					+ "money =? WHERE id = ?";
			PreparedStatement ps4 = conn.prepareStatement(sql4);
			ps4.setDouble(1, recMoney+mny);
			ps4.setString(2, recId);
			ps4.executeUpdate();
			/*
			 * 如果没有提交也没有回滚，这份数据就锁死了
			 * 谁都查不了，也该不了
			 */
			//提交事务
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			//回滚事务
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





































