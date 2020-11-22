import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

public class Exam3 {
	public static void main(String[] args) {
		String path = "test3.txt";
		// 읽은 내용이 담겨질 스트림
		byte[] data = null;
		// 읽은 내용을 문자열로 변환해서 저장
		String read_string = null;
		
		// 파일 읽기
		InputStream in = null;
		try {
			// 파일 열기
			in = new FileInputStream(path);
			// 읽은 내용을 저장하기 위한 배열은 파일의 용량만큼 사이즈를 할당해야 한다.
			// in.available() => 열려있는 파일의 크기 얻기
			data = new byte[in.available()];
			// 파일 읽기
			in.read(data);
			System.out.println("[INFO] 파일 읽기 성공 >> " + path);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없음 >> " + path);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 파일 읽기 실패 >> " + path);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러 >> " + path);
			e.printStackTrace();
		} finally {
			try {
				// 파일 닫기
				if(in != null) in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// byte 배열의 내용을 문자열로 변환
		if(data != null) {
			try {
				read_string = new String(data, "UTF-8");
				System.out.println(read_string);
			} catch (UnsupportedEncodingException e) {
				System.out.println("[ERROR] 인코딩 지정 에러");				
				e.printStackTrace();
			}
		}	
	}
}











