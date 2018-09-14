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
	 * ��������108��Ա��
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
				//�������ݴ浽ps������
				ps.setString(1, "�ú�"+i);
				ps.setString(2, "���");
				ps.setInt(3, 0);
				ps.setDate(4,new Date(System.currentTimeMillis()));
				ps.setDouble(5, 6000.0);
				ps.setDouble(6, 8000.0);
				ps.setInt(7, 3);
				ps.addBatch();
				//ÿ50�����������ύһ��
				if (i%50==0) {
					ps.executeBatch();
					//���ps���ݴ�����ݱ�����һ�����
					ps.clearBatch();
				}
			}
			//Ϊ�˱�������ͷ���ٶ��ύһ��
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
	 * ������һ�������ٸ��˲�������һ��Ա��
	 * Ҫ��:���Ӳ��ź���λ�����ɵĲ���ID.
	 */
	@Test
	public void test2(){
		/*
		 * ����ҳ�洫��Ĳ���������
		 */
		String dname = "���Բ�";
		String loc =  "����";
		//����ҳ�洫���Ա��������
		String ename="�˽�";
		String job = "ȡ��";
		int mgr =0;
		Date hireate = new Date(System.currentTimeMillis()
				);
		double sal = 5000.0;
		double comm = 1000.0;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			//����һ������
			String sql = 
					"INSERT INTO depts "
					+ "VALUES(depts_seq.nextval,?,?)";
			/*
			 * ����2��һ�����飬��������ps,
			 * ��Ҫ��������Щ�ֶ�
			 */
			PreparedStatement ps
			= conn.prepareStatement(sql,new String[]{"deptno"});
			ps.setString(1, dname);
			ps.setString(2, loc);
			ps.executeUpdate();
			
			//��ps�л�ȡ���ɵ�����
			//������а���һ��һ��
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			/*
			 * ��ȡ�����Ľ������ֻ��ͨ���ֶε���Ż�ȡ,����д�ֶ���
			 */
			int deptno = rs.getInt(1);
			System.out.println(deptno);
			//����һ��Ա��
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
			System.out.println("ִ��������");
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
	 * ��ҳ��ѯԱ��
	 */
	@Test
	public void test3(){
		//��������涨��ÿҳ��ʾ10��
		int size = 10;
		//�����û����˵���ҳ
		int page = 3;
		
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql="SELECT * FROM"+					
			"(SELECT empno,ename,job,mgr,hiredate,sal,comm,deptno,ROWNUM r FROM emps) e "
				+" WHERE e.r BETWEEN ? AND ?";
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			//��ʼ��
			ps.setInt(1, (page-1)*size+1);
			//��ֹ��
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
	 * 1 ����id�鵽Ա��
	 * 2 �޸Ĵ�Ա��������
	 */
	@Test
	public void test4(){
		//�˽�331
		EmpDao dao = new EmpDao();
		Emp e = dao.findById(331);
		if(e!=null){
			System.out.println(e.getEname());
			e.setEname("����ʦ");
			dao.update(e);
			System.out.println(e.getEname());
		}
		
	}
	
	//��Dept������������100������
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
			//���������������кű�������ֶ�Ҫ�󣬸����ֶ�û��commit����û��
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
	//ʹ��JDBC�ֱ�����Oracle���ݿ��MySQL���ݿ⣬ʵ�ֶ�Dept�����ݵķ�ҳ��ѯ���ܡ�
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
					//һ�����˱������ͱ����ñ�����ѯ
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

















