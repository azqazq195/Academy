<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
<%@ page import="패키지명.클래스명" %>
 --%>
<%
	Date date = new Date();
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년MM월dd일");
	String strDate = dateFormat.format(date);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(strDate != null) { %>
	<h3>오늘은 <%=strDate %> 입니다.</h3>
<% } else { %>
	<h3>날짜를 표시할 수 없습니다.</h3>
<% } %>
</body>
</html>






