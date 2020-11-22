<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${su > 0}">
	회원 가입 성공
</c:if>

<c:if test="${su == 0}">
	회원 가입 실패
</c:if>
<br>
<input type="button" value="메인 화면" onclick="location.href='../main/index.do'">

<%--
이름 : <%=name %><br>
아이디 : <%=id %><br>
비밀번호 : <%=pwd %><br>
성별 : <%=gender %><br>
이메일 : <%=email1 %>@<%=email2 %><br>
핸드폰 : <%=tel1 %>-<%=tel2 %>-<%=tel3 %><br>
주소 : <%=addr %><br>
 --%>
</body>
</html>





