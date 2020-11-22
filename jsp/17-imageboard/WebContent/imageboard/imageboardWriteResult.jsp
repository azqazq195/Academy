<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%--
	int su = (int)request.getAttribute("su");
	String imageName = (String)request.getAttribute("imageName");
--%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- request.setAttribute("이름", "데이터"); --%>
<%-- request 객체에 저장된 데이터를 el 표현식으로 읽어오기
	1. ${requestScope.이름}
	2. ${이름}
 --%>
<c:if test="${requestScope.su > 0}">
	<p>${requestScope.imageName} 상품 등록 완료</p>
</c:if>

<c:if test="${su == 0}">
	<p>${imageName} 상품 등록 실패</p>
</c:if>

<%--
<% if(su > 0)  {%>
	<p><%=imageName %> 상품 등록 완료</p>
<% } else { %>
	<p><%=imageName %> 상품 등록 실패</p>
<% } %>
 --%>
</body>
</html>