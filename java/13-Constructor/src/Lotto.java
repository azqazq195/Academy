import java.util.Random;
import java.util.Scanner;

public class Lotto {
	int[] m;    	// 로또번호 1세트
	int buyNum;		// 구매횟수
	
	public Lotto() {
		m = new int[6];
	}
	// 입력
	public void inputBuyNum() {
		Scanner sc = new Scanner(System.in);
		System.out.print("구매횟수를 입력하세요 : ");
		buyNum = sc.nextInt();
		System.out.println(); // 한줄 넘김
	}
	// 로또번호 1세트 생성
	public void selectLotto() {
		boolean chk = false;
		Random random = new Random();  // 임의 숫자를 만드는 클래스
		// 로또번호 1세트 : 1~45사이의 정수 6개로 구성
		m[0] = random.nextInt(45) + 1; // 0~44 + 1 => 1~45
		
		for(int a=1; a<6; ) {   		// 기준 위치
			m[a] = random.nextInt(45) + 1;
			chk = false;
			// 번호 중복 검사
			for(int b=0; b<a; b++) {  	// 비교 위치
				if(m[a]==m[b]) {
					chk = true;
					break;
				}
			}
			if(!chk) a++;
		}
	}
	// 로또번호 1세트 정렬 (오름차순) => 선택 정렬
	public void sort() {
		for(int x=0; x<5; x++) {		// 기준
			for(int y=x+1; y<6; y++) {	// 비교
				if(m[x] > m[y]) {	
					int temp = m[x];   	// 두값을 교환
					m[x] = m[y];
					m[y] = temp;
				}
			}
		}
	}
	// 로또번소 1세트 출력
	public void outputResult() {
		for(int i=0; i<m.length; i++) {
			System.out.printf("%2d ", m[i]);
		}
		System.out.println();  // 한줄 넘김
	}
	// 전체 관리
	public void doLotto() {
		inputBuyNum();
		for(int i=0; i<buyNum; i++) {
			selectLotto();
			sort();
			outputResult();
		}
	}
}








