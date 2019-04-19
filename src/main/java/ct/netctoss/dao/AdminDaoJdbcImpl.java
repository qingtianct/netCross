package ct.netctoss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import ct.netctoss.entity.Admin;

/**
 * 
 * @author ct
 *
 *持久化实现层
 */

@Repository("adminDAO")
public class AdminDaoJdbcImpl implements AdminDAO {
	
	@Resource(name="ds")
	private DataSource ds ;
	
	public Admin findByAdminCode(String adminCode) {
		
		Admin admin = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			String sql = "select * from admin_info_ct " 
			+ "where adminCode=?" ;
			PreparedStatement ps = conn.prepareStatement(sql) ;
			ps.setString(1,adminCode);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Admin a = new Admin();
				a.setAdminId(rs.getInt("adminId"));
				a.setAdminCode(rs.getString("adminCode"));
				a.setPassword(rs.getString("password"));
				a.setName(rs.getString("name"));
				a.setTelephone(rs.getString("telephone"));
				a.setEmail(rs.getString("email"));
				a.setEnrolldate(rs.getString("enrolldate"));
				admin = a;
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			System.out.println(e);
			
			throw new RuntimeException(e);
		}finally {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
					
					throw new RuntimeException(e);
				}
			}
		}
		return admin;
	}

	
	
}
