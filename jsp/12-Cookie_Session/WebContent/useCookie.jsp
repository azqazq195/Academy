<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(cookies != null) {
	for(int i=0; i<cookies.length; i++) {
%>
	쿠키의 이름은 "<%=cookies[i].getName() %>"이고, 
	쿠키의 값은 "<%=cookies[i].getValue() %>" 입니다.<br>
<%		
	}
}
%>
<hr>
<% if(cookies != null) {
	for(int i=0; i<cookies.length; i++) {
		if(cookies[i].getName().equals("id")) {
%>
	쿠키의 이름은 "<%=cookies[i].getName() %>"이고, 
	쿠키의 값은 "<%=cookies[i].getValue() %>" 입니다.<br>
<%		
		}
	}
}
%>
</body>
</html>






