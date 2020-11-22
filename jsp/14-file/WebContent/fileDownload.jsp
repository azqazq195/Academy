<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	// 데이터
	String fileName = request.getParameter("fileName");
	//System.out.println("fileName : " + fileName);
	// 파일이 저장된 실제 폴더 위치 구하기
	String realPath = request.getServletContext().getRealPath("/storage");
	// file 객체에 다운받을 파일의 절대경로 설정
	File file = new File(realPath, fileName);
	// file : D:\android_ycs\jsp\workspace\.metadata\.plugins
	//        \org.eclipse.wst.server.core\tmp0\wtpwebapps\14-file\storage\컵라면.jpg
	System.out.println("file : " + file);
	
	/* HTML 문서 형식이 아닌, "파일 다운로드 " 형태로 전송 */
	// response 객체를 통해 header 설정 : 파일의 정보만 설정
	// => 1. 파일의 이름, 2. 파일의 크기
	// => response.setHeader("이름", "데이터");
	
	// 1. 파일의 이름 설정
	String set_fileName = 
		new String(URLEncoder.encode(fileName, "UTF-8")).replace("\\+", " ");
//	String set_fileName = new String(fileName).replace("\\+", " ");
	response.setHeader("Content-Disposition", "attachment; fileName=" + set_fileName);
	// 2. 파일의 크기 설정
	response.setHeader("Content-Length", String.valueOf(file.length()));
	
	/* 파일 출력 */
	// 기존 jsp의 내장객체 out의  buffer를 비우고, 출력해야, 예외 발생이 안생김
	out.clear();
	out = pageContext.pushBody();
	
	// HDD에 저장된 파일을 RAM으로 읽어옴
	FileInputStream fis = new FileInputStream(file);
	BufferedInputStream bis = new BufferedInputStream(fis);
	byte[] b = new byte[(int)file.length()];
	bis.read(b, 0, b.length);
	bis.close();
	fis.close();
	
	// 클라이언트로 전송
	ServletOutputStream sos = response.getOutputStream();
	BufferedOutputStream bos = new BufferedOutputStream(sos);
	bos.write(b);
	bos.close();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>
