<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int num1 = 100;
	int num2 = 200;
	out.println(num2);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>오늘은 목요일</p>
	
	<p>마스크를 꼭 쓰고 다니세요..</p>
	<%=num1 %>
	<p>마스크가 없는 분들은 뒤에 비치된 마스크를 쓰시면 됩니다.</p>
	<% out.println(num2); %>
</body>
</html>





