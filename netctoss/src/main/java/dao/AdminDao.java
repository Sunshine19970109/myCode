package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import entity.Admin;
import util.DBUtil;

public class AdminDao implements Serializable {
	public Admin findByCode(String adminCode){
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = 
			"SELECT * FROM ADMIN_INFO "
			+ "WHERE admin_code=?";
			PreparedStatement ps
			=conn.prepareStatement(sql);
			ps.setString(1, adminCode);
			ResultSet rs = ps.executeQuery();
			Admin a = new Admin();
			if(rs.next()){
				a.setAdminId(rs.getInt("admin_id"));
				a.setAdminCode(rs.getString("admin_code"));
				a.setPassword(rs.getString("password"));
				a.setName(rs.getString("name"));
				a.setTelephone(rs.getString("TELEPHONE"));
				a.setEmail(rs.getString("email"));
				a.setEnrolldate(rs.getTimestamp("enrolldate"));
			}
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(
					"查询管理员失败",e);
		}finally{
			DBUtil.close(conn);
		}
	}
	@Test
	public void test(){
		AdminDao dao = new AdminDao();
		Admin a = dao.findByCode("CaoCao");
		System.out.println(a.getName());
	}
	public static void main(String[] args) {
		AdminDao dao = new AdminDao();
		Admin a = dao.findByCode("caocao");
		System.out.println(a);
	}
}



















