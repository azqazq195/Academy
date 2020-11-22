package score;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectInOut {
	// 파일 저장
	public boolean write(String fileName, List<ScoreVO> list) {
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		boolean result = false;
		
		try {
			// 1. 파일 열기
			fos = new FileOutputStream(fileName);
			oos = new ObjectOutputStream(fos);
			// 2. 파일 출력
			// 데이터 개수 출력
			oos.writeInt(list.size());
			// 객체 출력
			for(int i=0; i<list.size(); i++) {
				ScoreVO vo = list.get(i);
				oos.writeObject(vo);
			}
			result = true;
			//System.out.println("[INFO] 파일 저장 성공 >> " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없음 >> " + fileName);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 저장 실패 >> " + fileName);
			e.printStackTrace();
		}  catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러 >> " + fileName);
			e.printStackTrace();
		} finally {
			try {
				// 3. 파일 닫기
				if(oos != null) oos.close();
				if(fos != null) fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	// 파일 읽기
	public List<ScoreVO> read(String fileName) {
		List<ScoreVO> list = new ArrayList<ScoreVO>();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			// 1. 파일 열기
			fis = new FileInputStream(fileName);
			ois = new ObjectInputStream(fis);
			// 2. 파일 읽기
			// 데이터 개수 읽기
			int num = ois.readInt();
			// 객체 읽어서, 리스트에 저장하기
			for(int i=0; i<num; i++) {
				ScoreVO vo = (ScoreVO) ois.readObject();
				list.add(vo);
			}			
			System.out.println("[INFO] 파일 읽기 성공 >> " + fileName);
		} catch (FileNotFoundException e) {
			System.out.println("[ERROR] 저장 경로를 찾을 수 없음 >> " + fileName);
			list = null;	// 예외발생이므로 리스트를 초기화시킴
			//e.printStackTrace();
		} catch (IOException e) {
			System.out.println("[ERROR] 읽기 실패 >> " + fileName);
			list = null;	// 예외발생이므로 리스트를 초기화시킴
			//e.printStackTrace();
		}  catch (Exception e) {
			System.out.println("[ERROR] 알 수 없는 에러 >> " + fileName);
			list = null;	// 예외발생이므로 리스트를 초기화시킴
			//e.printStackTrace();
		} finally {
			try {
				// 3. 파일 닫기
				if(ois != null) ois.close();
				if(fis != null) fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}










