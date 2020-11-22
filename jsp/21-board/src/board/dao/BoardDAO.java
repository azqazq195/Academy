package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import board.bean.BoardBean;


public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	public BoardDAO() {
		try {
			Context context = new InitialContext();  // context.xml 파일읽기
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		} catch (NamingException e) {
			e.printStackTrace();
		}  
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
	// 글 등록 : insert
	public int insertArticle(BoardBean boardBean) {
		int insertCount = 0; // 처리 결과 저장
		String sql = "insert into board2 values " 
				   + "(seq_num.nextval, ?, ?, ?, ?, ?, seq_num.currval, 0, 0, 0, sysdate)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardBean.getBoard_name());
			pstmt.setString(2, boardBean.getBoard_pass());
			pstmt.setString(3, boardBean.getBoard_subject());
			pstmt.setString(4, boardBean.getBoard_content());
			pstmt.setString(5, boardBean.getBoard_file());
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return insertCount;
	}
	// 글의 개수 구하기
	public int selectListCount() {
		int listCount = 0;
		String sql = "select count(*) as cnt from board2";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt("cnt");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return listCount;
	}
	// 목록보기
	// => 답변 보기 기능이 추가된 코드로 수정
	public List<BoardBean> selectArticleList(int startNum, int endNum) {
		List<BoardBean> list = new ArrayList<BoardBean>();
		String sql = "select * from " 
		           + " (select rownum rn, tt.* from " 
				   + " (select * from board2 order by board_re_ref desc, board_re_seq asc) tt) " 
		           + " where rn>=? and rn<=?";
		/* String sql = "select * from " 
				   + " (select rownum rn, tt.* from " 
				   + " (select * from board2 order by board_num desc) tt) " 
				   + " where rn>=? and rn<=?";
		*/
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardBean boardBean = new BoardBean();
				boardBean.setBoard_num(rs.getInt("board_num"));
				boardBean.setBoard_name(rs.getString("board_name"));
				boardBean.setBoard_subject(rs.getString("board_subject"));
				boardBean.setBoard_content(rs.getString("board_content"));
				boardBean.setBoard_file(rs.getString("board_file"));
				boardBean.setBoard_re_ref(rs.getInt("board_re_ref"));
				boardBean.setBoard_re_lev(rs.getInt("board_re_lev"));
				boardBean.setBoard_re_seq(rs.getInt("board_re_seq"));
				boardBean.setBoard_readcount(rs.getInt("board_readcount"));
				boardBean.setBoard_date(rs.getString("board_date"));
				// 리스트에 저장
				list.add(boardBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	// 조회수 증가
	public int updateReadCount(int board_num) {
		int updateCount = 0;
		String sql = "update board2 set board_readcount=board_readcount+1 " 
				   + " where board_num=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return updateCount;
	}
	// 상세보기
	public BoardBean selectArticle(int board_num) {
		BoardBean boardBean = null;
		String sql = "select * from board2 where board_num=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardBean = new BoardBean();
				boardBean.setBoard_num(rs.getInt("board_num"));
				boardBean.setBoard_name(rs.getString("board_name"));
				boardBean.setBoard_subject(rs.getString("board_subject"));
				boardBean.setBoard_content(rs.getString("board_content"));
				boardBean.setBoard_file(rs.getString("board_file"));
				boardBean.setBoard_re_ref(rs.getInt("board_re_ref"));
				boardBean.setBoard_re_lev(rs.getInt("board_re_lev"));
				boardBean.setBoard_re_seq(rs.getInt("board_re_seq"));
				boardBean.setBoard_readcount(rs.getInt("board_readcount"));
				boardBean.setBoard_date(rs.getString("board_date"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return boardBean;
	}
	// 글쓴이 인지 확인
	public boolean isArticleBoardWriter(int board_num, String pw) {
		boolean isWriter = false;
		String sql = "select * from board2 where board_num=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs = pstmt.executeQuery();
			System.out.println("pw : " + pw);
			if(rs.next()) {
				if(pw.equals(rs.getString("board_pass"))) {
					isWriter = true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return isWriter;
	}
	// 글 삭제
	public int deleteArticle(int board_num) {
		int deleteCount = 0;
		String sql = "delete board2 where board_num=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return deleteCount;
	}
	// 수정
	public int updateArticle(BoardBean boardBean) {
		int updateCount = 0;
		String sql = "update board2 set board_subject=?, board_content=? " 
				   + " where board_num=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardBean.getBoard_subject());
			pstmt.setString(2, boardBean.getBoard_content());
			pstmt.setInt(3, boardBean.getBoard_num());
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return updateCount;
	}
	// 답변글 저장
	public int insertReplyArticle(BoardBean boardBean) {
		int insertCount = 0;
		String sql = "";
		int board_re_ref = boardBean.getBoard_re_ref();
		int board_re_lev = boardBean.getBoard_re_lev();
		int board_re_seq = boardBean.getBoard_re_seq();
		
		try {
			conn = ds.getConnection();
			// 1. 기존 답글의 등록 순서를 재정리함
			// => 원글 board_re_seq보다 큰 답글의 board_re_seq값을 1씩 증가
			sql = "update board2 set board_re_seq=board_re_seq+1 " 
			    + " where board_re_ref=? and board_re_seq>?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board_re_ref);
			pstmt.setInt(2, board_re_seq); 
			pstmt.executeUpdate();  // 실행, 처리된 결과값은 사용안함
			
			// 2. 추가된 답글의 board_re_seq는 원글 board_re_seq에 1 증가한 값을 가진다.
			//    추가된 답글의 board_re_lev는 원글 board_re_lev에 1 증가한 값을 가진다.
			board_re_seq = board_re_seq + 1;
			board_re_lev = board_re_lev + 1;
			sql = "insert into board2 values " 
			    + " (seq_num.nextval, ?, ?, ?, ?, ?, ?, ?, ?, 0, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardBean.getBoard_name());
			pstmt.setString(2, boardBean.getBoard_pass());
			pstmt.setString(3, boardBean.getBoard_subject());
			pstmt.setString(4, boardBean.getBoard_content());
			pstmt.setString(5, " "); // 답글에는 파일을 업로드 시키지 않음
			pstmt.setInt(6, board_re_ref);
			pstmt.setInt(7, board_re_lev);
			pstmt.setInt(8, board_re_seq);
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return insertCount;
	}
}










