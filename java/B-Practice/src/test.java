import java.util.HashMap;
import java.util.Scanner;

class test {
  private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
    // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
	  HashMap<Integer, Character> map = new HashMap<Integer, Character>();
	  for(int i=0; i<numOfAllPlayers; i++) {
		  map.put(i, (char)(65+i));
	  }
	  // 멤버와 위치, 0은 술래
	  int[] playersCount = new int[numOfAllPlayers];
	  boolean[] quickPlayers = new boolean[numOfAllPlayers];
	  int startNum = 1;
	  char temp = 0;
	  
	  // 빠른 참가자 true
	  for(int i=0; i<namesOfQuickPlayers.length; i++) {
		  quickPlayers[((int)namesOfQuickPlayers[i])-65]=true;
	  }
	  
	  // A카운트
	  playersCount[(int)(map.get(0))-65]++;
	  
	  for(int i=0; i<numOfGames; i++) {
		  startNum = startNum + numOfMovesPerGame[i];
		  if(startNum<1) startNum += (numOfAllPlayers-1);
		  if(startNum>(numOfAllPlayers-1)) startNum -= (numOfAllPlayers-1);
		  
		  if(quickPlayers[(int)(map.get(startNum)-65)]) {
			  playersCount[(int)(map.get(0))-65]++;
		  } else {
			  temp = map.get(startNum);
			  map.put(startNum, map.get(0));
			  map.put(0, temp);
			  playersCount[(int)(map.get(0))-65]++;
		  }
	  }
	  
	  for(int i=1; i<numOfAllPlayers; i++) {
		  System.out.println(map.get(i) + " " + playersCount[map.get(i)-65]);
	  }
	  System.out.println(map.get(0) + " " + playersCount[map.get(0)-65]);
  }

  private static class InputData {
    int numOfAllPlayers;
    int numOfQuickPlayers;
    char[] namesOfQuickPlayers;
    int numOfGames;
    int[] numOfMovesPerGame;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

      inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
      System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

      inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
      inputData.numOfMovesPerGame = new int[inputData.numOfGames];
      String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
      for(int i = 0; i < inputData.numOfGames ; i++){
        inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
  }
}