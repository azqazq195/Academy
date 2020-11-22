<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 	// 데이터 처리
	String num = request.getParameter("num");
	String name = request.getParameter("name");
	String grade = request.getParameter("grade");
	String subject = request.getParameter("subject");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>학생 정보</h2>
	<table border="1">
		<tr>
			<td width="150">학번</td>
			<td width="150"><%=num %></td>
		</tr>
		<tr>
			<td width="150">이름</td>
			<td width="150"><%=name %></td>
		</tr>
		<tr>
			<td width="150">학년</td>
			<td width="150"><%=grade %>학년</td>
		</tr>
		<tr>
			<td width="150">선택과목</td>
			<td width="150"><%=subject %></td>
		</tr>
	</table>
	<hr>
	<h2>request 객체의 메소드</h2>
	클라이언트IP = <%=request.getRemoteAddr() %><br>
	요청정보 길이 = <%=request.getContentLength() %><br>
	요청정보 인코딩 = <%=request.getCharacterEncoding() %><br>
	요청정보 컨텐드 타입 = <%=request.getContentType() %><br>
	요청정보 프로토콜 = <%=request.getProtocol() %><br>
	요청정보 전송방식 = <%=request.getMethod() %><br>
	요청 URI = <%=request.getRequestURI() %><br>
	요청 URL = <%=request.getRequestURL() %><br>
	컨텍스트 경로 = <%=request.getContextPath() %><br>
	서버이름 = <%=request.getServerName() %><br>
	서버포트 = <%=request.getServerPort() %><br>
	<hr>
	<h2>헤더 정보</h2>
<%
	Enumeration header = request.getHeaderNames();
	while(header.hasMoreElements()) {
		String headerName = (String) header.nextElement();
		String headerValue = request.getHeader(headerName);
		out.println(headerName + " = " + headerValue + "<br>");
	}
%>	
</body>
</html>













