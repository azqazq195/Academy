<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	/*
		form 태그의 enctype="multipart/form-data"로 설정되어 있으면,
		request 객체로는 문자열을 읽어올 수 없음
	*/
	//String subject = request.getParameter("subject");
	//out.println("제목 : " + subject);
	
	// 실제 파일 저장 폴더 위치 확인
	// realFolder : D:\android_ycs\jsp\workspace\.metadata\.plugins
	//              \org.eclipse.wst.server.core\tmp0\wtpwebapps\14-file\storage
	String realFolder = request.getServletContext().getRealPath("/storage");
	System.out.println("realFolder : " + realFolder);
	
	// 업로드 : 서버에 파일 저장  
	// 1Kbyte : 1024byte
	// new DefaultFileRenamePolicy() : 업로드시, 똑같은 파일 이름이 있을 경우,
	//								   기존 파일 이름에 숫자를 덧붙여서 저장한다.
	MultipartRequest multi = new MultipartRequest(request, realFolder, 5*1024*1024,
											"UTF-8", new DefaultFileRenamePolicy());
	String subject = multi.getParameter("subject");
	String content = multi.getParameter("content");
	
	// 클라이언트에서 서버로 보낸 파일 이름
	String originalFileName1 = multi.getOriginalFileName("upload1");
	String originalFileName2 = multi.getOriginalFileName("upload2");
	// 서버의 storage 폴더에 저장된 파일 이름
	String fileName1 = multi.getFilesystemName("upload1");
	String fileName2 = multi.getFilesystemName("upload2");
	// 서버에 저장된 파일의 크기
	File file1 = multi.getFile("upload1");
	File file2 = multi.getFile("upload2");
	System.out.println("file1 : " + file1);
	
	long fileSize1 = 0;
	long fileSize2 = 0;
	if(file1 != null) fileSize1 = file1.length();
	if(file2 != null) fileSize2 = file2.length();
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>제목 : <%=subject %></li>
		<li>내용 : <%=content %></li>
		<li>파일 : 
			<a href="fileDownload.jsp?fileName=<%=originalFileName1%>">
				<%=originalFileName1%></a>
			&nbsp;&nbsp;&nbsp;&nbsp; <%=fileName1 %>
		</li>
		<li>크기 : <%=fileSize1 %></li>
		<br><br>
		<li>파일 : <%=originalFileName2 %>
				&nbsp;&nbsp;&nbsp;&nbsp; <%=fileName2 %></li>
		<li>크기 : <%=fileSize2 %></li>
	</ul>
	<img alt="그림1" src="storage/<%=fileName1%>" width="50" height="50">
	<img alt="그림2" src="storage/<%=fileName2%>" width="50" height="50">
</body>
</html>








