package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class UpdateTest {
	// 1. Driver 등록 확인 
	public UpdateTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	// 2. Connection 객체 생성
	public Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "javaexam";
		String password = "m1234";
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("접속 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	// 3. SQL 작업
	public void updateArticle() {
		// 데이터
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 이름 입력 : ");
		String name = sc.next();
		// DB
		// 1) 접속
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		int su = 0;
		// "update dbtest set age=age+1 where name like '%홍%'"
		String sql = "update dbtest set age=age+1 where name like ?";
		try {
			// 2) 데이터 처리
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");
			su = pstmt.executeUpdate();
			System.out.println(su + "개의 행이 수정되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 3) 접속끊기
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
public class Exam4 {
	public static void main(String[] args) {
		UpdateTest updateTest = new UpdateTest();
		updateTest.updateArticle();
	}
}






