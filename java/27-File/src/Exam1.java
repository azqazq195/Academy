import java.io.File;
import java.io.IOException;

public class Exam1 {
	public static void main(String[] args) {
		// File 클래스의 기본 사용법
		// => 파일과 폴더를 관리하는 클래스
		// 이클립스에서 상대경로를 사용할 경우, 현재 프로젝트가 기준이 됨
		File f1 = new File("src/Main1.java");
		//File f1 = new File("src/test.txt");
		System.out.println("f1 = " + f1);
		// 전달된 경로가 파일인지 검사
		// -> 존재하지 않는 파일로 검사할 경우, 무조건 false
		System.out.println("파일 : " + f1.isFile());
		// 전달된 경로가 폴더인지 검사
		// -> 존재하지 않는 폴더로 검사할 경우, 무조건 false
		System.out.println("폴더 : " + f1.isDirectory());
		// 전달된 경로가 숨김형태인지 검사
		// -> 존재하지 않는 폴더로 검사할 경우, 무조건 false
		System.out.println("숨김 : " + f1.isHidden()); 
		// 절대 경로값을 추출
		System.out.println("절대 경로 : " + f1.getAbsolutePath());
		// 파일이나 폴더가 실제로 존재하는 지 검사
		System.out.println("존재여부 : " + f1.exists());
		// 파일 만들기
		try {
			f1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("존재여부 : " + f1.exists());
		// 파일 없애기
		f1.delete();
		System.out.println("존재여부 : " + f1.exists());
		System.out.println("-----------------------");
		
		// 폴더
		File f2 = new File("a/b/c/target");
		System.out.println("f2 = " + f2);
		System.out.println("파일 : " + f2.isFile());
		System.out.println("폴더 : " + f2.isDirectory());
		System.out.println("숨김 : " + f2.isHidden()); 
		System.out.println("절대 경로 : " + f2.getAbsolutePath());
		System.out.println("존재여부 : " + f2.exists());
		// 폴더(=디렉토리) 만들기
		f2.mkdirs();
		System.out.println("존재여부 : " + f2.exists());
		// 마지막 "/" 이후 단어를 리턴
		System.out.println(f1.getName());
		System.out.println(f2.getName());
		// 처음부터 마지막 "/" 직전까지 리턴
		System.out.println(f1.getParent());
		System.out.println(f2.getParent());
		// 폴더 삭제
		f2.delete();
		System.out.println("존재여부 : " + f2.exists());
	}
}










