import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public class Exam2_2 {
	// 스트림 형태로 출력 : 1byte단위로 출력
	public static void main(String[] args) {
		String path = "test3.txt";
		String write_string = "가나다라마바사abcdefg";  // 자바에서 문자열은 2바이트로 처리됨
		
		// 문자열을 byte배열로 변환
		// 특정 인코딩 방식 설정 : utf-8		
		byte[] buffer = null;
		try {
			buffer = write_string.getBytes("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		// 파일 저장 절차 시작
		// finally 블록에서 인식하기 위해서 선언부를 try{} 블럭 위로 이동시킨다.
		OutputStream out = null;
		try {
			// 파일을 만들면서, 파일을 오픈시킴
			out = new FileOutputStream(path);
			// 파일 쓰기
			out.write(buffer);
			System.out.println("[INFO] 파일 저장됨 >> " + path);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 저장에 실패했습니다.");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러가 발생했습니다.");
		} finally {
			try {
				// 파일 닫기
				if(out != null) out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}







