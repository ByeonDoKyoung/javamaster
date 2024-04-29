package co.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class UsersDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	private void getConn(){
		String url = "jdbc:oracle:thin:@192.168.0.64:1521:xe";
		
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "jsp", "jsp");
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}	
	// 로그인
	public boolean login(Users user) {
		getConn();
		String sql = "select * from users where users_id =? and users_pw = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUsersId());
			psmt.setString(2, user.getUsersPw());
			rs = psmt.executeQuery();
			
			if(rs != null) {
				return true;
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	// 등록
	public boolean insertusers(Users user) {
		getConn();
		String sql = "insert into users (users_date, users_id, users_pw, users_name, users_birthday, users_phone)\r\n"
				+ "values (?, ?, ?, ?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUsersDate());
			psmt.setString(2, user.getUsersId());
			psmt.setString(3, user.getUsersPw());
			psmt.setString(4, user.getUsersName());
			psmt.setString(5, user.getUsersBirthday());
			psmt.setString(6, user.getUsersPhone());
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		return false;
	}
	
	// 수정
	public boolean Updateusers(Users user) {
		getConn();
		
		String sql = "Update users";
		sql += "set users_name =?, users_phone = ?";
		sql += "where users_Id = ? ";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUsersName());
			psmt.setString(2, user.getUsersPhone());
			psmt.setString(3, user.getUsersId());
			
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		return true; 
	}
	
	
	public boolean deleteusers(Users user) {
		getConn();
		String sql = "delete from users"
				+ "where users_Id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getUsersId());
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();	
		}
		return false;
	}	
}//