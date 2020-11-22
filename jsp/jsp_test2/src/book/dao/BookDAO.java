package book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import book.dto.BookDTO;

public class BookDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	public BookDAO() {
		try {
			javax.naming.Context context = new InitialContext();
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	// 도서 등록 : insert
	public int insertArticle(BookDTO bookDTO) {
		int insertCount = 0; // 처리 결과 저장
		String sql ="insert into book values (?, ?, ?, ?, ?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bookDTO.getBookCode());
			pstmt.setString(2, bookDTO.getBookName());
			pstmt.setString(3, bookDTO.getArtist());
			pstmt.setString(4, bookDTO.getPublisher());
			pstmt.setInt(5, bookDTO.getBookPrice());
			
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return insertCount;
	}
	
	// 책 목록의 갯수 구하기
	public int selectListCount() {
		int listCount = 0;
		String sql = "select count(*) as cnt from book";
		
		try {
			conn = ds.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return listCount;
	}
	
	// 도서 목록을 1~10으로 출력시키기
	public java.util.List<BookDTO> selectArticleList(int startNum, int endNum) {
		java.util.List<BookDTO> list = new ArrayList<BookDTO>();		
		String sql = "select * " + 
				" from (select rownum rn, tt. * from (select * from book order by bookCode asc) tt) " + 
				" where rn>=? and rn<=?";
		
		try {
			conn = ds.getConnection();			
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, startNum);
			pstmt.setInt(2, endNum);			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BookDTO bookDTO = new BookDTO();
				bookDTO.setBookCode(rs.getInt("bookcode"));
				bookDTO.setBookName(rs.getString("bookname"));
				bookDTO.setArtist(rs.getString("artist"));
				bookDTO.setPublisher(rs.getString("publisher"));
				bookDTO.setBookPrice(rs.getInt("bookprice"));
				
				list.add(bookDTO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}
	
	
}
