
public class Exam2 {
	public static void main(String[] args) {
		int[][] grade = new int[3][3];
		String[] name = {"홍길동", "김철수", "이영희"};
		// 홍길동 점수 입력
		grade[0][0] = 75;
		grade[0][1] = 82;
		grade[0][2] = 95;
		// 김철수 점수 입력
		grade[1][0] = 88;
		grade[1][1] = 64;
		grade[1][2] = 70;
		// 이영희 점수 입력
		grade[2][0] = 100;
		grade[2][1] = 95;
		grade[2][2] = 90;
		
		// 총점과 평균구해서 출력
		for(int x=0; x<grade.length; x++) {
			int sum = 0;
			int avg = 0;
			
			for(int y=0; y<grade[x].length;y++) {
				sum += grade[x][y];
			}
			avg = sum / grade[x].length;
			
			System.out.println(name[x] + ", 총점=" + sum + ", 평균=" + avg);
		}
	}
}





