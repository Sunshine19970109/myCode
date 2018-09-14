package cn.tedu.netctoss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import cn.tedu.netctoss.entity.Cost;
/**
 * Cost持久层实现
 * @author dell
 *
 */
//@Repository("costDAO")
public class CostDaoImpl implements CostDao{
	@Resource(name="ds")
	private DataSource ds;
	public List<Cost> findAllCost() {
		List<Cost> costs = new ArrayList<Cost>();
		Connection conn = null;
		try {
			conn= ds.getConnection();
			String sql = 
					"SELECT * FROM cost "
					+ "ORDER BY cost_id";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
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
				costs.add(c);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("获取连接失败",e);
		}finally{
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException("关闭连接失败",e);
				}
			}
		}
		
		return costs;
	}


}
