import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Exam2 {
	// 문자열만 파일로 출력
	public static void main(String[] args) {
		String str = "가나다라마바사abcdefg";
		String path = "text2.txt";
		//String path = "src/Exam1.java";
		// 파일 출력		
		try {
			FileWriter fileWriter = new FileWriter(path);
			fileWriter.write(str);
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 파일 입력
		try {
			FileReader fileReader = new FileReader(path);
			String result = "";
			while(true) {
				int data = fileReader.read();
				if(data == -1) break;
				result += (char)data;
			}
			System.out.println(result);
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}










