package test.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import test.bean.ScoreVO;
import test.service.ScoreService;
import test.service.ScoreServiceImpl;

@Component
public class HelloSpring {	
	Scanner sc = new Scanner(System.in);
	@Autowired
	ScoreService scoreService;
	
	public ScoreService getScoreService() {
		return scoreService;
	}
	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	
	// 메뉴
	public void menu() {
		int num = 0;
		while(true) {
			do {
				System.out.println();
				System.out.println("1. 입력");
				System.out.println("2. 출력");
				System.out.println("3. 학번 검색");
				System.out.println("4. 수정");
				System.out.println("5. 삭제");
				System.out.println("6. 종료");
				System.out.println("-------");
				System.out.print("번호 : ");
				num = sc.nextInt();			
			} while(num>6 || num<1);
			
			switch(num) {
			case 1: score_insert(); break;  // 입력
			case 2: score_list(); break;  	// 출력
			case 3: score_search(); break;  // 학번 검색
			case 4: score_modify(); break;  // 수정
			case 5: score_delete(); break;  // 삭제
			case 6: System.out.println("프로그램 종료..."); 
					return;
			}
		}
	}
	
	// 입력
	public void score_insert() {
		ScoreVO vo = new ScoreVO();
		System.out.println();
		System.out.print("학번 : ");
		vo.setStudNo(sc.next());
		System.out.print("이름 : ");
		vo.setName(sc.next());
		System.out.print("국어 : ");
		vo.setKor(sc.nextInt());
		System.out.print("영어 : ");
		vo.setEng(sc.nextInt());
		System.out.print("수학 : ");
		vo.setMat(sc.nextInt());
		
		int tot = vo.getKor() + vo.getEng() + vo.getMat();
		vo.setTot(tot);
		vo.setAvg((double)tot/3);
		
		int result = scoreService.insertScore(vo);
		if(result > 0) {
			System.out.println("저장 성공");
		} else {
			System.out.println("저장 실패");
		}
	}
	// 수정
	public void score_modify() {
		ScoreVO vo = new ScoreVO();
		System.out.println();
		System.out.print("수정할 학번 : ");
		vo.setStudNo(sc.next());		
		System.out.print("국어 : ");
		vo.setKor(sc.nextInt());
		System.out.print("영어 : ");
		vo.setEng(sc.nextInt());
		System.out.print("수학 : ");
		vo.setMat(sc.nextInt());
		
		int tot = vo.getKor() + vo.getEng() + vo.getMat();
		vo.setTot(tot);
		vo.setAvg((double)tot/3);
		
		int result = scoreService.updateScore(vo);
		if(result > 0) {
			System.out.println("수정 성공");
		} else {
			System.out.println("수정 실패");
		}
	}
	// 삭제
	public void score_delete() {
		ScoreVO vo = new ScoreVO();
		System.out.println();
		System.out.print("삭제할 학번 : ");	
		vo.setStudNo(sc.next());
		
		int result = scoreService.deleteScore(vo);
		if(result > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");
		}
	}
	// 목록보기
	public void score_list() {
		List<ScoreVO> list = scoreService.getScoreList();
		String resultTitle = String.format("%10s%10s%5s%5s%5s%5s%5s  %10s",
							"학번","이름","국어","영어","수학","총점","평균", "입력일");
		System.out.println(resultTitle);
		for(ScoreVO vo : list) {
			System.out.println(vo.toString());
		}
	}
	
	// 학번 검색
	private void score_search() {
		ScoreVO vo = new ScoreVO();
		
		System.out.println();
		System.out.print("검색할 학번 : ");
		vo.setStudNo(sc.next());
		
		vo = scoreService.getScore(vo);
		
		if(vo != null) {
			System.out.println(vo.toString());
		} else {
			System.out.println("학번 검색 실패입니다.");
		}
	}
	
	public static void main(String[] args) {
		GenericXmlApplicationContext context = 
				new GenericXmlApplicationContext("bean.xml");
		
		HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
//		ScoreService scoreService = 
//				(ScoreServiceImpl) context.getBean("scoreServiceImpl"); 
//		helloSpring.setScoreService(scoreService);
		helloSpring.menu();
		
		context.close();
	}
}

