package com.dao;

import java.util.Scanner;

public class Exam1 {
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		Scanner sc1 = new Scanner(System.in);
		
		try {
			// 프로젝트안에 특정 클래스가 존재하는 지 검사
			// => 클래스가 없으면 예외 발생시킴
			// => 클래스명은 클래스 풀네임으로 작성
			// 클래스 풀네임 : 패키지명.클래스명   
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 등록 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 등록 실패");
			//e.printStackTrace();
		}
	}
}








