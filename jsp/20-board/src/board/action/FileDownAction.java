package board.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownAction implements Action{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1. 데이터 처리
		String fileName = request.getParameter("downFile");
		// 실제 폴더위치 구하기
		String realPath = request.getServletContext().getRealPath("/boardUpload");
		// 다운 받고자 하는 파일 이름을 관리하는 File 객체 생성
		File file = new File(realPath, fileName);
		
		// HTML 문서가 아니라 "파일 다운로드" 형태로 전송
		// => response 헤더 설정
		response.setHeader("Content-Disposition", "attachment; fileName=" 
					+ new String(URLEncoder.encode(fileName, "UTF-8")).replaceAll("\\+", " "));
		response.setHeader("Content-Length", String.valueOf(file.length()));
		// HDD에 저장된 파일을 RAM으로 읽어옴
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		byte[] b = new byte[(int)file.length()];
		bis.read(b, 0, b.length);  // 배열 b에 저장
		bis.close();
		fis.close();
		// 클라이언트로 전송
		ServletOutputStream sos = response.getOutputStream();
		BufferedOutputStream bos = new BufferedOutputStream(sos);
		bos.write(b); 
		bos.close();			
		return null;
	}

}
