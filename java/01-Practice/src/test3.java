import java.util.Scanner;
import java.util.regex.Pattern;

/*
1
R2(G(B3B))

RGBGBGBGBGBGBGBGB
 */


class test3 {
  private static void solution(int numOfOrder, String[] orderArr) {
	  
	  for(int i=0; i<orderArr.length; i++) {
		  System.out.println(stringMethod(orderArr[i]));
	  }
	  
	  
  }
  
  static String stringMethod(String str) {
	  int start = str.lastIndexOf('(');
	  int end = str.indexOf(')');
	  
	  String newTemp = "";
	  String temp1 = str.substring(0, start-1);
	  String temp2 = str.substring(end+1, str.length());
	  String temp = str.substring(start+1, end);
	  
	  if(temp.matches(".*[0-9].*")) {
		  
		  for(int i=0; i<temp.length(); i++) {
			  String numStr = String.valueOf(temp.charAt(i));
			  if(numStr.matches(".*[0-9].*")) {
				  String ntemp1 = temp.substring(0, i);
				  String ntemp2 = temp.substring(i+2, temp.length());

				  int num = Integer.parseInt(numStr);
				  String character = String.valueOf(temp.charAt(i+1));
				  
				  while(num-->0) {
					  ntemp1 += character;
				  }
				  
				  temp = ntemp1 + ntemp2;
				  
			  }
		  }
	  }
	  
	  char kind = str.charAt(start-1);
	  int num = (int)kind - 48;
	  if(kind == 'R' || kind == 'G' || kind == 'B') {
	      for (int i=0; i<=temp.length()-1; i++){
	    	  newTemp += String.valueOf(kind) + temp.charAt(i);
	      }
	  } else {
		  while(num-->0) {
			  newTemp += temp;
		  }
	  }
	  str = temp1 + newTemp + temp2;
	  
	  if(str.contains("(")) {
		  return stringMethod(str);
	  }
	  
	  
	  
	  return str;
  }

  private static class InputData {
    int numOfOrder;
    String[] orderArr;
  }

  private static InputData processStdin() {
    InputData inputData = new InputData();

    try (Scanner scanner = new Scanner(System.in)) {
      inputData.numOfOrder = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

      inputData.orderArr = new String[inputData.numOfOrder];
      for (int i = 0; i < inputData.numOfOrder; i++) {
        inputData.orderArr[i] = scanner.nextLine().replaceAll("\\s+", "");
      }
    } catch (Exception e) {
      throw e;
    }

    return inputData;
  }

  public static void main(String[] args) throws Exception {
    InputData inputData = processStdin();

    solution(inputData.numOfOrder, inputData.orderArr);
  }
}