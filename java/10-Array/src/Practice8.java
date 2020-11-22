
public class Practice8 {
	public static void main(String[] args) {
		// 선언, 입력
		int[][] a = {{1, 2, 3, 0},
					 {4, 5, 6, 0},
					 {7, 8, 9, 0},
					 {0, 0, 0, 0}};
		// 연산
		for(int x=0; x<3; x++) {  	// 행
			for(int y=0; y<3; y++) {// 열
				a[x][3] += a[x][y]; // 행 더하기
				a[3][x] += a[y][x]; // 열 더하기
				a[3][3] += a[x][y]; // 전체 더하기
			}
		}
		// 출력
		for(int x=0; x<4; x++) {  	// 행
			for(int y=0; y<4; y++) {// 열
				System.out.printf("%3d", a[x][y]);
			}
			System.out.println();
		}
	}
}
