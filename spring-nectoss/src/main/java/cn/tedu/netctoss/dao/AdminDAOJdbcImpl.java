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

import cn.tedu.netctoss.entity.Admin;
/**
 * 持久层实现
 * @author dell
 *
 */
//@Repository("adminDAO")
public class AdminDAOJdbcImpl implements AdminDAO {
	@Resource(name="ds")
	private DataSource ds;
	
	public Admin findByAdminCode(String adminCode) {
		Admin admin = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			String sql = "SELECT * FROM ADMIN_INFO "
					+ "WHERE admin_code=?";
			PreparedStatement ps = 
					conn.prepareStatement(sql);
			ps.setString(1, adminCode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				admin = new Admin();
				admin.setAdminId(rs.getInt("admin_id"));
				admin.setAdminCode(rs.getString("admin_code"));
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("name"));
				admin.setTelephone(rs.getString("TELEPHONE"));
				admin.setEmail(rs.getString("email"));
				admin.setEnrolldate(rs.getTimestamp("enrolldate"));
			}
		} catch (SQLException e) {
			//step1.记日志(保留现场)
			e.printStackTrace();
			/*
			 * step2.看异常能否恢复，如果不能够
			 * 恢复(比如数据库服务暂停，网络中断，
			 * 这样的一样一般我们称之为系统异常)，
			 * 则提示用户稍后重试。如果能够恢复则，
			 * 立即恢复。
			 */
			throw new RuntimeException("数据库连接异常",e);
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
		return admin;
	}

	
}
