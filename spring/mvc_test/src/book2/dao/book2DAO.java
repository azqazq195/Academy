package book2.dao;

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

import book2.bean.book2DTO;

public class book2DAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	
	public book2DAO() {
		try {
			Context context = new InitialContext();
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
	
	// 책 등록 :insert (return su - 처리결과) 
		public int insertBook(book2DTO dto) {
			int su = 0;	//처리결과 저장 (su와 같음)
			String sql="insert into book2 values (?, ?, ?, ?, ?, ?)";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getCode());
				pstmt.setString(2, dto.getTitle());
				pstmt.setString(3, dto.getAuthor());
				pstmt.setString(4, dto.getPublisher());
				pstmt.setInt(5, dto.getPrice());
				pstmt.setString(6, dto.getPubliDate());
				
				su = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			return su;
		}
		
		// 모든 책 정보 불러오기
		public List<book2DTO> selectList(int startNum, int endNum) {
			List<book2DTO> list = new ArrayList<book2DTO>();
			String sql = "select * from " + 
					" (select rownum rn, tt.* from " + 
					" (select * from book2 order by code asc) tt) " + 
					" where rn>=? and rn<=? ";
			
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, startNum);
				pstmt.setInt(2, endNum);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					book2DTO dto = new book2DTO();
					dto.setCode(rs.getString("code"));
					dto.setTitle(rs.getString("title"));
					dto.setAuthor(rs.getString("author"));
					dto.setPublisher(rs.getString("publisher"));
					dto.setPrice(rs.getInt("price"));
					dto.setPubliDate(rs.getString("publiDate"));
					
					// 리스트에 저장 (각각 불러와서 dto에 각각 저장하고, 리스트에 저장!)
					list.add(dto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close();
			}
			return list;
			
		}
		
		
		//총 도서 수 구하기 :select (return listCount) 
			public int getListCount () {
				int listCount = 0;
				String sql = "SELECT COUNT(*) as cnt FROM book2";
				
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
	
	
}
