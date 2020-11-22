<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String result = "";
	if(age>= 20) {
		result = name + "님의 나이는 20세 이상입니다.";
	} else {
		result = name + "님은 미성년자입니다.";
	}	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(age >= 20) { %>
	<%=name %>님의 나이는 20세 이상입니다.
<% } else { %>
	<%=name %>님은 미성년자 입니다.
<% } %>
<br><br>
<%= result %>
</body>
</html>







