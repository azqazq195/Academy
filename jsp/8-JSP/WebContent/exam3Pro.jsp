<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int number1 = Integer.parseInt(request.getParameter("number1"));
	int number2 = Integer.parseInt(request.getParameter("number2"));
	int result = number1 + number2;
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>두 수의 합 구하기</h2>
	<p><%=number1 %> + <%=number2 %> = <%=result %></p>
</body>
</html>





