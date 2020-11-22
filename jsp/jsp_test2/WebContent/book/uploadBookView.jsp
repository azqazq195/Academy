<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int result = 0;
	if(!request.getParameter("result").equals("") && request.getParameter("result") != null) {
		result = Integer.parseInt(request.getParameter("result"));
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(result > 0) { %>
		저장 성공 !
	<% } else { %>
		저장 실패 ㅠㅠ result = <%=result %>
	<% } %>
	
</body>
</html>