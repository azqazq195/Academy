package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class InsertTest {
	// 1. Driver 등록 확인
	public InsertTest() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}	
	// 2. connection (오라클서버에 접속)
	public Connection getConnection() {
		// 오라클서버와 접속된 후, 접속을 관리하는 클래스
		Connection conn = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // ip와 port 정보
		String user = "javaexam"; 	// 사용자 계정 이름
		String password = "m1234"; 	// 비밀번호
		try {
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("접속 성공");
		} catch (SQLException e) {
			System.out.println("접속 실패");
			e.printStackTrace();
		}
		return conn;
	}
	// 3. SQL 작업처리 (데이터 저장)	
	public void insertArticle() {
		// 데이터
		Scanner sc = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = sc.next();
		System.out.print("나이 입력 : ");
		int age = sc.nextInt();
		System.out.print("키 입력 : ");
		double height = sc.nextDouble();
		// DB 작업
		// 1) 오라클 서버에 접속
		Connection conn = getConnection();
		// 실제 오라클서버에 요청과 응답처리
		PreparedStatement pstmt = null;
		int su = 0;
		//"insert into dbtest values ('홍익인간', 45, 173.89, sysdate)"
		String sql = "insert into dbtest values (?, ?, ?, sysdate)";
		
		try {
			// 2) 데이터 처리
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name); 
			pstmt.setInt(2, age); 
			pstmt.setDouble(3, height); 
			su = pstmt.executeUpdate();
			System.out.println(su + "개의 행이 만들어졌습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 3) 접속 끊기
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}	
}
public class Exam2 {
	public static void main(String[] args) {
		InsertTest insertTest  = new InsertTest();
		insertTest.insertArticle();
	}
}






