package day03;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Test;

import dao.EmpDao;
import entity.Emp;
import util.DBUtil;

public class TestDay03 {
	
	/**
	 * 批量增加108个员工
	 */
	@Test
	public void test1(){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = 
					"INSERT INTO emps "
					+ "VALUES(emps_seq.nextval,"
					+ "?,?,?,?,?,?,?)";
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			for(int i=1;i<=108;i++){
				//将数据暂存到ps对象里
				ps.setString(1, "好汉"+i);
				ps.setString(2, "打劫");
				ps.setInt(3, 0);
				ps.setDate(4,new Date(System.currentTimeMillis()));
				ps.setDouble(5, 6000.0);
				ps.setDouble(6, 8000.0);
				ps.setInt(7, 3);
				ps.addBatch();
				//每50条数据批量提交一次
				if (i%50==0) {
					ps.executeBatch();
					//清空ps中暂存的数据便于下一批添加
					ps.clearBatch();
				}
			}
			//为了避免有零头，再多提交一次
			ps.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			DBUtil.rollback(conn);
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 先增加一个部门再给此部门增加一个员工
	 * 要点:增加部门后如何获得生成的部门ID.
	 */
	@Test
	public void test2(){
		/*
		 * 假设页面传入的部门数据是
		 */
		String dname = "测试部";
		String loc =  "杭州";
		//假设页面传入的员工数据是
		String ename="八戒";
		String job = "取经";
		int mgr =0;
		Date hireate = new Date(System.currentTimeMillis()
				);
		double sal = 5000.0;
		double comm = 1000.0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			//增加一个部门
			String sql = 
					"INSERT INTO depts "
					+ "VALUES(depts_seq.nextval,?,?)";
			/*
			 * 参数2是一个数组，用来告诉ps,
			 * 需要它返回那些字段
			 */
			PreparedStatement ps
			= conn.prepareStatement(sql,new String[]{"deptno"});
			ps.setString(1, dname);
			ps.setString(2, loc);
			ps.executeUpdate();
			
			//从ps中获取生成的主键
			//结果集中包含一行一列
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			/*
			 * 获取主键的结果集，只能通过字段的序号获取,不能写字段名
			 */
			int deptno = rs.getInt(1);
			System.out.println(deptno);
			//增加一个员工
			String sql2 =
			"INSERT INTO emps VALUES"
			+ "(emps_seq.nextval,?,"
			+ "?,?,?,?,?,?)";
			PreparedStatement ps2
			= conn.prepareStatement(sql2);
			
			ps2.setString(1, ename);
			
			ps2.setString(2, job);
			ps2.setInt(3,mgr);
			ps2.setDate(4, hireate);
			ps2.setDouble(5, sal);
			
			ps2.setDouble(6, comm);
			ps2.setInt(7, deptno);
			System.out.println("执行在这里");
			ps2.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 分页查询员工
	 */
	@Test
	public void test3(){
		//假设需求规定了每页显示10行
		int size = 10;
		//假设用户点了第三页
		int page = 3;
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql="SELECT * FROM"+					
			"(SELECT empno,ename,job,mgr,hiredate,sal,comm,deptno,ROWNUM r FROM emps) e "
				+" WHERE e.r BETWEEN ? AND ?";
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			//起始行
			ps.setInt(1, (page-1)*size+1);
			//终止行
			ps.setInt(2, page*size);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.print(rs.getInt("empno")+"---");
				System.out.println(rs.getString("ename"));
			}
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
	
	/**
	 * 1 根据id查到员工
	 * 2 修改次员工的数据
	 */
	@Test
	public void test4(){
		//八戒331
		EmpDao dao = new EmpDao();
		Emp e = dao.findById(331);
		if(e!=null){
			System.out.println(e.getEname());
			e.setEname("苍老师");
			dao.update(e);
			System.out.println(e.getEname());
		}
		
	}
	
	//向Dept表中批量插入100条数据
	@Test
	public void test5(){
		Connection conn = null;
		try {
			conn= DBUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "INSERT INTO dept VALUES"
					+ "(dept_seq.nextval,?,?)";
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			for(int i=0;i<100;i++){
				ps.setString(1, "name"+i);
				ps.setString(2, "tianjin");
				ps.addBatch();
				if(i%20==0){
					ps.executeBatch();
					ps.clearBatch();
				}	
			}
			//往表里面插入的序列号必须符合字段要求，改完字段没有commit等于没改
			ps.executeBatch();
			conn.commit();
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
	//使用JDBC分别连接Oracle数据库和MySQL数据库，实现对Dept表数据的分页查询功能。
		@Test
		public void test6(){
			Connection conn = null;
			try {
				int page = 2;
				int size = 5;
				conn = DBUtil.getConnection();
				String sql = "SELECT * FROM (SELECT ROWNUM r,deptno,dname,loc "
						+ "FROM dept) d "
						+ "WHERE d.r BETWEEN ? AND ?";
				PreparedStatement ps=
						conn.prepareStatement(sql);
				ps.setInt(1, (page-1)*size+1);
				ps.setInt(2, page*size);
				ResultSet rs = ps.executeQuery();
				while(rs.next()){
					//一旦起了别名，就必须用别名查询
					int row = rs.getInt("r");
					int deptno = rs.getInt("deptno");
					String dname = rs.getString("dname");
					String loc = rs.getString("loc");
					System.out.println(row+" "+deptno+" "+dname+" "+loc);
				}
				
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

















