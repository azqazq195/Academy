<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	// 세션에 데이터 저장
	session.setAttribute("id", id);
	session.setAttribute("pwd", pwd);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션</title>
</head>
<body>
	<h2>세션 속성 설정 및 사용</h2>
	<p>id 속성의 값은 <%=session.getAttribute("id") %>이고<br>
	   pwd 속성의 값은 <%=(String)session.getAttribute("pwd") %> 입니다.
	</p>
</body>
</html>





