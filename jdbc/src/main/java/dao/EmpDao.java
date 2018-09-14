package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entity.Emp;
import util.DBUtil;

public class EmpDao implements Serializable{
	/**
	 * ����һ��Ա��
	 * @param emp
	 */
	public void save(Emp emp){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "INSERT INTO  emps"
					+ "(ename,job,mgr,hiredate,sal,comm,deptno,empno) VALUES("
					+ "ename = ?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=?,empno=?) "; 
			PreparedStatement ps
			= conn.prepareStatement(sql);
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getJob());
			ps.setInt(3, emp.getMgr());
			ps.setDate(4, emp.getHiredate());
			ps.setDouble(5, emp.getSal());
			ps.setDouble(6, emp.getComm());
			ps.setInt(7, emp.getDeptno());
			ps.setInt(8, emp.getEmpno());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("����Ա��ʧ��",e);
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر�����ʧ��",e);
			}
		}	
	}
	/**
	 * ����ID�޸�Ա��
	 * @param emp
	 */
	public void update(Emp emp){
		//��������
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
					"UPDATE emps SET "
					+ "ename = ?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=? "
					+ "WHERE empno=?";
			PreparedStatement ps
			= conn.prepareStatement(sql);
			ps.setString(1, emp.getEname());
			ps.setString(2, emp.getJob());
			ps.setInt(3, emp.getMgr());
			ps.setDate(4, emp.getHiredate());
			ps.setDouble(5, emp.getSal());
			ps.setDouble(6, emp.getComm());
			ps.setDouble(7, emp.getDeptno());
			ps.setInt(8, emp.getEmpno());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"�޸�Ա��ʧ��",e);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر�����ʧ��",e);
			}
		}
	}
	
	/**
	 * ����IDɾ��һ��Ա��
	 * @param id
	 */
	public void delete(int id){
		Connection conn = null;
		try {
			conn= DBUtil.getConnection();
			String sql = "DELETE * FROM emps WHERE empno = ?";
			PreparedStatement ps
			= conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ɾ��Ա��ʧ��",e	);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر�����ʧ��",e);
			}
		}
		
	}
	
	/**
	 * ����ID��ѯһ��Ա��
	 * @param id
	 * @return
	 */
	public Emp findById(int id){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM emps "
					+ "WHERE empno =? ";
			PreparedStatement ps
			= conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeQuery();
			//����ֱ�ӷ��ؽ��������Ϊ�ر�����ֱ�����
			ResultSet rs = ps.getResultSet();
			if(rs.next()){
				Emp e = new Emp();
				e.setEmpno(rs.getInt("empno"));
				e.setEname(rs.getString("ename"));
				e.setJob(rs.getString("job"));
				e.setMgr(rs.getInt("mgr"));
				e.setHiredate(rs.getDate("hiredate"));
				e.setSal(rs.getDouble("sal"));
				e.setComm(rs.getDouble("comm"));
				e.setDeptno(rs.getInt("deptno"));
				
				return e;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("����Ա��ʧ��",e);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر�����ʧ��",e);
			}
		}
		return null;
	}
	
	/**
	 * ���ݲ��Ų�ѯԱ��
	 * @param deptno
	 * @return
	 */
	public List<Emp> findByDept(int deptno){
		List<Emp> emps = new ArrayList<Emp>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM emps "
					+ "WHERE deptno =? ";
			PreparedStatement ps
			= conn.prepareStatement(sql);
			ps.setInt(1, deptno);
			ps.executeQuery();
			//����ֱ�ӷ��ؽ��������Ϊ�ر�����ֱ�����
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				Emp e = new Emp();
				e.setEmpno(rs.getInt("empno"));
				e.setEname(rs.getString("ename"));
				e.setJob(rs.getString("job"));
				e.setMgr(rs.getInt("mgr"));
				e.setHiredate(rs.getDate("hiredate"));
				e.setSal(rs.getDouble("sal"));
				e.setComm(rs.getDouble("comm"));
				e.setDeptno(rs.getInt("deptno"));
				emps.add(e);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("���Ҳ���Ա��ʧ��",e);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر�����ʧ��",e);
			}
		}
		return emps;
	}
	
	/**
	 * ��������Ա��
	 * @param emps
	 */
	public void saveAll(List<Emp> emps){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "INSERT INTO  emps"
					+ "(ename,job,mgr,hiredate,sal,comm,deptno,empno) VALUES("
					+ "ename = ?,job=?,mgr=?,hiredate=?,sal=?,comm=?,deptno=dept_seq.NEXTVAL,empno=?) "; 
			PreparedStatement ps
			= conn.prepareStatement(sql);
			conn.setAutoCommit(false);
			for (int i = 0 ;i< emps.size();i++) {
				ps.setString(1, emps.get(i).getEname());
				ps.setString(2, emps.get(i).getJob());
				ps.setInt(3, emps.get(i).getMgr());
				ps.setDate(4, emps.get(i).getHiredate());
				ps.setDouble(5, emps.get(i).getSal());
				ps.setDouble(6, emps.get(i).getComm());
				ps.setInt(7, emps.get(i).getEmpno());
				ps.addBatch();
				if(i%10==0){
					ps.executeBatch();
				}
			}
			ps.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��������Ա��ʧ��",e);
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException("�ر�����ʧ��",e);
			}
		}	
	}
	
}
















