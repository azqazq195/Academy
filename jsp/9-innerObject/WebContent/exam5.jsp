<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String info = application.getServerInfo();
	String path = application.getRealPath(""); // 절대경로 끝에 "/" 추가
	application.log("로그 기록 : " + info);		// Console 창에 로그 내용을 출력
	System.out.println("로그 기록 : " + info);     // 디버깅용
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>application 객체</h2>
	<p>웹 컨테이너의 이름과 버전 : <%=info %></p>
	<p>웹 어플리케이션 폴더의 로컬 시스템 경로 : <%=path %></p>
</body>
</html>






