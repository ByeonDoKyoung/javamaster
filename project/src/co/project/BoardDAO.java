package co.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	private void getConn() {
		String url = "jdbc:oracle:thin:@192.168.0.64:1521:xe";
		
		try {	
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, "jsp", "jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//등록
	public boolean insertBoard(Board board) {
		getConn();
		
		String sql = "insert into board (board_postnum, board_title, board_detail, board_views)"
				+ "values (board_seq.nextval,?,?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getBoardtitle());
			psmt.setString(2, board.getBoarddetail());
			psmt.setString(3, board.getBoardviews());
			
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
	public boolean UpdateBoard(Board board) {
		getConn();
		
		String sql = "Update board ";
		sql += "set board_title =? , board_detail = ?";
		sql += "where board_postnum = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getBoardtitle());
			psmt.setString(2, board.getBoarddetail());
			psmt.setString(3, board.getBoardpostnum());
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 삭제
	public boolean deleteboard(Board board) {
		getConn();
		
		String sql = "delete from board where board_postnum = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, board.getBoardpostnum());
			
			int r = psmt.executeUpdate();
			if(r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 조회
	public List<Board> selectBoard() {
		getConn();
		
		String sql = "select board_postnum, board_title, board_detail, board_views from board";
		
		List<Board> boards = new ArrayList<Board>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				String postnum = rs.getString("board_postnum");
				String title = rs.getString("board_title");
				String detail = rs.getString("board_detail");
				String views = rs.getString("board_views");

				Board board = new Board();
				
				board.setBoardpostnum(postnum.toString());
				board.setBoardtitle(title);
				board.setBoarddetail(detail);
				board.setBoardviews(views.toString());

		  		boards.add(board);
			}
		}catch (SQLException e) {
			e.printStackTrace();	
		}
		
		return boards;
	}			
}//