package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Cost;
import util.DBUtil;

public class CostDao implements Serializable {
	//��ѯ����Ա���õ�����
	public List<Cost> findAll() {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
					"SELECT * FROM cost "
					+ "ORDER BY cost_id";
			Statement smt=
					conn.createStatement();
			ResultSet rs = smt.executeQuery(sql);
			List<Cost> list = new ArrayList<Cost>();
			while(rs.next()){
				Cost c = new Cost();
				c.setCostId(rs.getInt("cost_id"));
				c.setName(rs.getString("name"));
				c.setBaseDuration(rs.getInt("base_duration"));
				c.setBaseCost(rs.getDouble("base_cost"));
				c.setUnitCost(rs.getDouble("unit_cost"));
				c.setStatus(rs.getString("status"));
				c.setDescr(rs.getString("descr"));
				c.setCreatime(rs.getTimestamp("creatime"));
				c.setStartime(rs.getTimestamp("startime"));
				c.setCostType(rs.getString("cost_type"));
				list.add(c);
			}
			smt.close();
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��ѯ�ʷ�ʧ��"
					,e);
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();	
			}
		}
	}
	
	public void save(Cost cost) {
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
				"insert into cost values("
				+ "cost_seq.nextval,"
				+ "?,?,?,?,'1',?,sysdate,null,?)";
			PreparedStatement ps = 
				conn.prepareStatement(sql);
			ps.setString(1, cost.getName());
			/*setInt,setDouble��������null,
			 * ����ʵ��ҵ���и��ֶ�ȴ����Ϊnull,
			 * �������ݿ�Ҳ֧��Ϊnull,���Խ�������
			 * �ֶε���Object����
			 * */
			ps.setObject(2, cost.getBaseDuration());
			ps.setObject(3, cost.getBaseCost());
			ps.setObject(4, cost.getUnitCost());
			ps.setString(5, cost.getDescr());
			ps.setString(6, cost.getCostType());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
				"����ʧ��", e);
		} finally {
			DBUtil.close(conn);
		}
	}
	
	public Cost findById(Integer id){
		Connection conn =null;
		try {
			conn = DBUtil.getConnection();
			String sql = "SELECT * FROM cost "
					+ "WHERE COST_ID =?";
			PreparedStatement ps
			=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			//���������Ǽ�ֵ��
			Cost c = new Cost();
			while (rs.next()) {
				c.setCostId(rs.getInt("cost_id"));
				c.setName(rs.getString("name"));
				c.setBaseDuration(rs.getInt("base_duration"));
				c.setBaseCost(rs.getDouble("base_cost"));
				c.setUnitCost(rs.getDouble("unit_cost"));
				c.setStatus(rs.getString("status"));
				c.setDescr(rs.getString("descr"));
				c.setCreatime(rs.getTimestamp("creatime"));
				c.setStartime(rs.getTimestamp("startime"));
				c.setCostType(rs.getString("cost_type"));	
			}
			return c;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("��������ʧ��",e);
		}finally{
			
			DBUtil.close(conn);
		}
	}
	
	public void update(Cost c){
		Connection conn=null;
		try {
			conn= DBUtil.getConnection();
			String sql = "UPDATE COST SET "
					+ "NAME=?,BASE_DURATION=?,BASE_COST=?,"
					+ "UNIT_COST=?,COST_TYPE=?,DESCR=? "
					+ "WHERE cost_id=?";
			PreparedStatement ps=
					conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setObject(2, c.getBaseDuration());
			ps.setObject(3, c.getBaseCost());
			ps.setObject(4, c.getUnitCost());
			ps.setString(5, c.getCostType());
			ps.setString(6, c.getDescr());
			ps.setInt(7, c.getCostId());
			System.out.println(ps.executeUpdate());
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
	}
	
	public void delete(int id){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "DELETE FROM cost WHERE cost_id=?";
			PreparedStatement ps =
					conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("ɾ���ʷ�ʧ��",e);
		}finally{
			DBUtil.close(conn);
		}
	}
	public static void main(String[] args) {
		CostDao dao = new CostDao();
		dao.delete(100);
//		Cost cost = new Cost();
//		cost.setName("66Ԫ�ײ�");
//		cost.setBaseDuration(660);
//		cost.setBaseCost(1222.0);
//		cost.setUnitCost(0.6);
//		cost.setDescr("������ˬ");
//		cost.setCostType("1");
//		cost.setCostId(100);
//		dao.update(cost);
		
	}
	
}

































