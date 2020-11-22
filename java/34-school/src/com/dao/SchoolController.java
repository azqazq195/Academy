package com.dao;

import java.util.List;
import java.util.Scanner;

public class SchoolController {
	Scanner sc = new Scanner(System.in);
	SchoolDAO dao = new SchoolDAO();
	
	// menu
	public void menu() {
		int num = 0;
		while(true) {
			System.out.println();
			System.out.println("*******************");
			System.out.println("  관리");
			System.out.println("*******************");
			System.out.println("  1. 입력");
			System.out.println("  2. 검색");
			System.out.println("  3. 삭제");
			System.out.println("  4. 종료");
			System.out.println("*******************");
			System.out.print("번호 선택 : ");
			num = sc.nextInt();
			
			switch(num) {
			case 1: insert(); break;  // 입력
			case 2: select(); break;  // 검색
			case 3: delete(); break;  // 삭제
			case 4:
				System.out.println("프로그램 종료");
				System.exit(0);				
			}
		}
	}	
	// insert
	public void insert() {
		int num = 0;
		while(true) {
			System.out.println();
			System.out.println("*******************");
			System.out.println("  1. 학생");
			System.out.println("  2. 교수");
			System.out.println("  3. 관리자");
			System.out.println("  4. 이전메뉴");
			System.out.println("*******************");
			System.out.print("번호 선택 : ");
			num = sc.nextInt();
			
			if(num == 4) break;  // 이전메뉴로 돌아감
			
			System.out.print("이름 입력 : ");
			String name = sc.next();
			String value = "";
			int code = 0;
			
			switch(num) {
			case 1:	// 학생
				System.out.print("학번 입력 : ");
				value = sc.next();
				code = 1;
				break;
			case 2: // 교수
				System.out.print("과목 입력 : ");
				value = sc.next();
				code = 2;
				break;
			case 3: // 관리자
				System.out.print("부서 입력 : ");
				value = sc.next();
				code = 3;
				break;
			}
			SchoolDTO schoolDTO = new SchoolDTO(name, value, code);
			int su = dao.insertArticle(schoolDTO);
			System.out.println(su + "개의 행이 만들어졌습니다.");
		}
	}
	// delete
	public void delete() {
		System.out.print("삭제를 원하는 이름 입력 : ");
		String name = sc.next();
		int su = dao.deleteArticle(name);
		if(su>0) System.out.println("삭제되었습니다.");
		else System.out.println("삭제 실패입니다.");
	}
	// select : 전체 검색, 부분 검색
	public void select() {
		String name = "";
		List<SchoolDTO> list = null;
		SchoolDTO schoolDTO = null;
		int num = 0;
		while(true) {
			System.out.println();
			System.out.println("*******************");
			System.out.println("  1. 이름 검색");
			System.out.println("  2. 전체 검색");
			System.out.println("  3. 이전 메뉴");
			System.out.println("*******************");
			System.out.print("번호 선택 : ");
			num = sc.nextInt();
			
			if(num == 3) break;
			switch(num) {
			case 1:  // 이름 검색
				System.out.print("검색할 이름 입력 : ");
				name = sc.next();
				schoolDTO = dao.selectArticle(name);
				output(schoolDTO);
				break;
			case 2:  // 전체 검색
				list = dao.selectList();
				for(int i=0; i<list.size(); i++) {
					schoolDTO = list.get(i);
					output(schoolDTO);
				}
				break;
			}
		}
	}
	// 1명 데이터 출력
	public void output(SchoolDTO schoolDTO) {
		System.out.print("이름: " + schoolDTO.getName() + "\t");
		
		if(schoolDTO.getCode() == 1) {
			System.out.println("학번: " + schoolDTO.getValue());
		} else if(schoolDTO.getCode() == 2) {
			System.out.println("과목: " + schoolDTO.getValue());
		} else if(schoolDTO.getCode() == 3) {
			System.out.println("부서: " + schoolDTO.getValue());
		} 
	}
}














