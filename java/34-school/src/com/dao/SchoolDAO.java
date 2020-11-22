package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
// Oracle 서버에 접속하여 데이터를 CRUD 처리하는 클래스
public class SchoolDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "javaexam";
	String password = "m1234";
	
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// 1. driver 등록 확인
	public SchoolDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// 2. Connection 객체 생성
	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	// 접속 끊기
	public void close() {
		try {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 3. Sql 작업
	// (1) insert
	public int insertArticle(SchoolDTO schoolDTO) {
		int su = 0;
		// insert into school values ('홍길동','2018001', 1)
		String sql = "insert into school values (?, ?, ?)";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schoolDTO.getName());
			pstmt.setString(2, schoolDTO.getValue());
			pstmt.setInt(3, schoolDTO.getCode());
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return su;
	}
	// (2) delete
	public int deleteArticle(String name) {
		int su = 0;
		// "delete school where name='홍길동'"
		String sql = "delete school where name=?";
		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			su = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return su;
	}
	// (3) select : 전체 검색
	public List<SchoolDTO> selectList() {
		List<SchoolDTO> list = new ArrayList<SchoolDTO>();
		String sql = "select * from school";
		// 1) 접속
		conn = getConnection();
		try {
			// 2) 데이터 처리
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				SchoolDTO schoolDTO = new SchoolDTO();
				schoolDTO.setName(rs.getString("name")); 
				schoolDTO.setValue(rs.getString("value")); 
				schoolDTO.setCode(rs.getInt("code")); 
				// 리스트에 저장
				list.add(schoolDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 3) 접속끊기
			close();
		}
		return list;
	}
	// (4) select : 부분 검색 (제일먼저 나타나는 딱 1명만 검색)
	public SchoolDTO selectArticle(String name) {
		SchoolDTO schoolDTO = null;
		// "select * from school where name like '%홍%'"
		String sql = "select * from school where name like ?";
		// 1) 접속
		conn = getConnection();
		try {
			// 2) 데이터 처리
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String name1 = rs.getString("name");
				String value = rs.getString("value");
				int code = rs.getInt("code");
				schoolDTO = new SchoolDTO(name1, value, code);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 3) 접속 끊기
			close();
		}
		return schoolDTO;
	}
}













