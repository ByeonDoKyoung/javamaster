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
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, "jsp", "jsp");
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}	

	void login(Users user) {
		getConn();
		String sql = "String users_id, String users_pw";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();		
			}catch (SQLException e) {
			e.printStackTrace();	
			}
			return;
			}
	
	
	boolean insertusers(Users user) {
		getConn();
		String sql = "insert into users (users_date,susers_id, users_pw, users_name, users_birthday, users_phone)\r\n"
				+ "values (users_seq.nextval, ?, ?, ?, ?, ?, ?)";
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
	
	
	

	boolean Updateusers(Users user) {
		getConn();
		String sql = "Update  users";
		sql += "where users_Id = ? ";
		
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
		return true; 
	}
	
	
	boolean deleteusers(int eno) {
		getConn();
		String sql = "delete from users"
				+ "where users_Id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, eno);
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