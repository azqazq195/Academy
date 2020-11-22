package score.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import score.bean.ScoreDTO;


public class ScoreDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "javaexam";
	String password = "m1234";
	
	// jdbc 관련 변수
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// sql 명령어들
	String score_insert = "insert into score values (?,?,?,?,?,?,?,sysdate)";
	String score_update = "update score set kor=?,eng=?,mat=?,tot=?,avg=? " 
					    + " where studno=?";
	String score_delete = "delete score where studno=?";
	String score_get = "select * from score where studno=?";
	String score_list = "select * from " 
					  + " (select rownum rn, tt.* from " 
					  + " (select * from score order by studNo asc) tt)" 
					  + " where rn>=? and rn<=?";
	String score_count = "select count(*) as cnt from score";
	
	public ScoreDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {		
		try {			
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return conn;
	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/** crud 기능의 메소드 구현 **/
	// 성적 등록
	public int insertScore(ScoreDTO dto) {
		int result = 0;	
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(score_insert);
			pstmt.setString(1, dto.getStudNo());
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMat());
			pstmt.setInt(6, dto.getTot());
			pstmt.setDouble(7, dto.getAvg());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	// 성적 수정
	public int updateScore(ScoreDTO dto) {
		int result = 0;	
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(score_update);			
			pstmt.setInt(1, dto.getKor());
			pstmt.setInt(2, dto.getEng());
			pstmt.setInt(3, dto.getMat());
			pstmt.setInt(4, dto.getTot());
			pstmt.setDouble(5, dto.getAvg());
			pstmt.setString(6, dto.getStudNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	// 성적 삭제
	public int deleteScore(ScoreDTO dto) {
		int result = 0;	
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(score_delete);				
			pstmt.setString(1, dto.getStudNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
	// 성적 목록보기
	public List<ScoreDTO> getScoreList(int startNum, int endNum) {
		List<ScoreDTO> list = new ArrayList<ScoreDTO>();
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(score_list);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ScoreDTO dto = new ScoreDTO();
				dto.setStudNo(rs.getString("studno"));
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMat(rs.getInt("mat"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getDouble("avg"));
				dto.setLogtime(rs.getString("logtime"));
				// 리스트에 저장
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	// 성적 상세보기
	public ScoreDTO getScore(ScoreDTO dto) {
		ScoreDTO scoreDTO = null;
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(score_get);
			pstmt.setString(1, dto.getStudNo());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				scoreDTO = new ScoreDTO();
				scoreDTO.setStudNo(rs.getString("studno"));
				scoreDTO.setName(rs.getString("name"));
				scoreDTO.setKor(rs.getInt("kor"));
				scoreDTO.setEng(rs.getInt("eng"));
				scoreDTO.setMat(rs.getInt("mat"));
				scoreDTO.setTot(rs.getInt("tot"));
				scoreDTO.setAvg(rs.getDouble("avg"));
				scoreDTO.setLogtime(rs.getString("logtime"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return scoreDTO;
	}
	
	// 총 데이터 수 구하기
	public int selectListCount() {
		int result = 0;
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(score_count);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}
}

















