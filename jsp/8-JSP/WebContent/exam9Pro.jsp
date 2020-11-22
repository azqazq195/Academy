<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String result = "";
	
	if(id.equals("root") && pw.equals("1234")) {
		result = "로그인에 성공했습니다.";
	} else {
		result = "로그인에 실패했습니다.";
	}	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><%=result %></p>
</body>
</html>





