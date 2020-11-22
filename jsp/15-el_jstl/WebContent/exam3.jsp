<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	<%
		String name="홍길동";
		int age = 25;
	%>
	나의 이름은 <%=name %> 입니다.<br>
	내 나이는 <%=age %>살 입니다.<br>
	나의 키는<%=height%> 입니다.<br>
 --%>
	<hr>
	<h3>** 변수 설정 **</h3>
	<c:set var="name">홍길동</c:set>
	<c:set var="age" value="25"/>
	나의 이름은 ${name} 입니다.<br>
	내 나이는 ${age}살 입니다.<br>
	나의 키는 ${height} 입니다.<br>
	<hr>
	
	<h3>** 변수 삭제 **</h3>
	<c:remove var="name"/>
	나의 이름은 ${name} 입니다.<br>
	내 나이는 ${age}살 입니다.<br>
	나의 키는 ${height} 입니다.<br>
	<hr>
	
	<h3>** forEach (for문 대체)**</h3>
	<!-- for(int i=1; i<=10; i++) -->
	<c:forEach var="i" begin="1" end="10" step="1">
		${i} &nbsp;&nbsp;
		<c:set var="sum" value="${sum + i}" />
	</c:forEach>
	<br>
	1~10 까지의 합 = ${sum}
	<hr>
		
	<c:set var="arr" value="10, 20, 30, 40, 50"/>
	
	<!-- for(int data : arr) -->
	<c:forEach var="data" items="${arr}">
		${data} &nbsp;&nbsp;
	</c:forEach>
</body>
</html>












