import java.util.Scanner;

class test2 {
	static int count = 0;
	static int line[];
  private static void solution(int day, int width, int[][] blocks) {
    // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
	  line = new int[blocks[0].length];
	  for(int i=0; i<blocks.length; i++) {
		  find(blocks[i]);
	  }
	  System.out.println(count);
  }
  
  static void find(int[] land) {
	  for(int i=0; i<land.length; i++) {
		  line[i] += land[i];
	  }
	  
	  for(int i=0; i<line.length; i++) {
		  int leftNum = 0;
		  int rightNum = 0;
		  int num = line[i];
		  if(i==0) continue;
		  if(i==line.length-1) break;
		  
		  // 왼쪽 찾기
		  for(int j=i-1; j>=0; j--) {
			  if(leftNum < line[j]) leftNum = line[j];
		  }
		  // 오른쪽 찾기
		  for(int j=i+1; j<line.length; j++) {
			  if(rightNum < line[j]) rightNum = line[j];
		  }
		  int plus = leftNum > rightNum ? rightNum : leftNum;
		  if(plus <= line[i]) continue;
		  count += (plus - line[i]);
		  line[i] = plus;
	  }
	  
  }
  
  private static class InputData {
    int day;
    int width;
    int[][] blocks;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));      
      inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      
      inputData.blocks = new int[inputData.day][inputData.width];
      for (int i = 0; i < inputData.day; i++) {
        String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
        for (int j = 0; j < inputData.width; j++) {
          inputData.blocks[i][j] = Integer.parseInt(buf[j]);
        }
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.day, inputData.width, inputData.blocks);
  }
}