package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class SelectTest {
	// 1. 드라이버 등록 확인
	public SelectTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// 2. Connetion 객체 생성 함수
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "javaexam";
		String password = "m1234";
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	// 3. SQL 작업 처리
	public void selectArticle() {
		// 1) 접속
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select  *  from  dbtest";
		try {
			// 2) 데이터 처리
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				double height = rs.getDouble("height");
				String logtime = rs.getString("logtime");
				System.out.println(name + "\t" + age + "\t" + height + "\t" + logtime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 3) 접속 끊기
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
}
public class Exam3 {
	public static void main(String[] args) {
		SelectTest selectTest = new SelectTest();
		selectTest.selectArticle();
	}
}





