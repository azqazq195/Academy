package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.bean.BoardDTO;

public class BoardDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String username = "javaexam";
	String password = "m1234";
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BoardDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	public  void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 데이터 저장 : insert
	public int boardWrite(BoardDTO boardDTO) {
		int su = 0;
		String sql = "insert into board values " 
				   + "(seq_board.nextval, ?, ?, ?, ?, 0, sysdate)";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getId());
			pstmt.setString(2, boardDTO.getName());
			pstmt.setString(3, boardDTO.getSubject());
			pstmt.setString(4, boardDTO.getContent());
			
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	
	// 데이터 삭제 : delete
	public int boardDelete(int seq) {
		int su = 0;
		String sql = "delete board where seq=?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq); 
			
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	
	// 조회수 증가 : update
	public int updateHit(int seq) {
		int su = 0;
		String sql = "update board set hit=hit+1 where seq=?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq); 
			
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return su;
	}
	
	// 목록보기 : select
	public List<BoardDTO> boardList(int startNum, int endNum) {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		String sql = "select seq, id, name, subject, content, hit, "
				   + " to_char(logtime, 'YYYY.MM.DD')as logtime from " 
				   + " (select rownum rn, tt.* from " 
				   + " (select * from board order by seq desc) tt) " 
				   + " where rn>=? and rn<=?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(rs.getString("logtime"));
				// 리스트에 저장
				list.add(boardDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	// 상세보기 : select	
	public BoardDTO boardView(int seq) {
		BoardDTO boardDTO = null;
		String sql = "select * from board where seq=?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, seq);			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardDTO = new BoardDTO();
				boardDTO.setSeq(rs.getInt("seq"));
				boardDTO.setId(rs.getString("id"));
				boardDTO.setName(rs.getString("name"));
				boardDTO.setSubject(rs.getString("subject"));
				boardDTO.setContent(rs.getString("content"));
				boardDTO.setHit(rs.getInt("hit"));
				boardDTO.setLogtime(rs.getString("logtime"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return boardDTO;
	}
	
	// 총 목록 수 구하기 : select
	public int getTotalA() {
		int totalA = 0;
		String sql = "select count(*) as cnt from board";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalA = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return totalA;
	}
}











