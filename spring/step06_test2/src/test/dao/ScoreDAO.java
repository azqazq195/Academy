package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import test.bean.ScoreVO;

@Repository
public class ScoreDAO {
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
	String score_list = "select * from score";
	
	/** crud 기능의 메소드 구현 **/
	// 성적 등록
	public int insertScore(ScoreVO vo) {
		int result = 0;	
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(score_insert);
			pstmt.setString(1, vo.getStudNo());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, vo.getKor());
			pstmt.setInt(4, vo.getEng());
			pstmt.setInt(5, vo.getMat());
			pstmt.setInt(6, vo.getTot());
			pstmt.setDouble(7, vo.getAvg());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	// 성적 수정
	public int updateScore(ScoreVO vo) {
		int result = 0;	
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(score_update);			
			pstmt.setInt(1, vo.getKor());
			pstmt.setInt(2, vo.getEng());
			pstmt.setInt(3, vo.getMat());
			pstmt.setInt(4, vo.getTot());
			pstmt.setDouble(5, vo.getAvg());
			pstmt.setString(6, vo.getStudNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	// 성적 삭제
	public int deleteScore(ScoreVO vo) {
		int result = 0;	
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(score_delete);				
			pstmt.setString(1, vo.getStudNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return result;
	}
	// 성적 목록보기
	public List<ScoreVO> getScoreList() {
		List<ScoreVO> list = new ArrayList<ScoreVO>();
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(score_list);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ScoreVO vo = new ScoreVO();
				vo.setStudNo(rs.getString("studno"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				vo.setTot(rs.getInt("tot"));
				vo.setAvg(rs.getDouble("avg"));
				vo.setLogtime(rs.getString("logtime"));
				// 리스트에 저장
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return list;
	}
	
	// 성적 상세보기
	public ScoreVO getScore(ScoreVO vo) {
		ScoreVO scoreVO = null;
		conn = JDBCUtil.getConnection();
		try {
			pstmt = conn.prepareStatement(score_get);
			pstmt.setString(1, vo.getStudNo());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				scoreVO = new ScoreVO();
				scoreVO.setStudNo(rs.getString("studno"));
				scoreVO.setName(rs.getString("name"));
				scoreVO.setKor(rs.getInt("kor"));
				scoreVO.setEng(rs.getInt("eng"));
				scoreVO.setMat(rs.getInt("mat"));
				scoreVO.setTot(rs.getInt("tot"));
				scoreVO.setAvg(rs.getDouble("avg"));
				scoreVO.setLogtime(rs.getString("logtime"));				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return scoreVO;
	}
}















