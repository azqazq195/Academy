<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<style type="text/css">
body {
	margin:0;
	padding: 0;
	height: 100%;
}
#header {
	width: 100%;
	height: 10%;
	text-align: center;
	border: 1px solid lightgray;
}
#container {
	width: 100%;
	height: 450px;
}
#nav {
	width: 20%;
	height: 100%;
	background: orange;
	float: left;
}
#section {
	width: 80%;
	height: 100%;
	float: left;
}
#footer {
	width: 100%;
	height: 10%;
	clear: both;
	text-align: center;
	border: 1px solid lightgray;
}
#main:link {color: black; text-decoration: none;}
#main:visited {color: black; text-decoration: none;}
#main:active {color: black; text-decoration: none;}
#main:hover {color: green; text-decoration: underline;}
</style>
</head>
<body>
	<div id="header">
		<h1>게시판</h1>
	</div>
	
	<div id="container">
		<div id="nav">
			<h3><a href="../main/index.jsp" id="main">* 메인 화면 *</a></h3>
			<br>
		<%-- // 로그 아웃 상태 --%>
		<c:if test="${sessionScope.memId == null}">
			<a href="memberWriteForm.do">회원가입</a><br>
			<a href="loginForm.do">로그인</a><br>
		</c:if>
		
		<%-- // 로그인 상태 --%>
		<c:if test="${memId != null }">
			<a href="#">글쓰기</a><br>
			<a href="logout.do">로그아웃</a><br>
			<a href="memberModifyFormReady.do">회원정보수정</a><br>
			<a href="memberList.do?pg=1">회원목록보기</a><br>	
			<a href="memberDeleteForm.do">회원탈퇴</a><br>
		</c:if>
			
			<a href="#">목록</a><br>
		</div>
		
		<div id="section">
		<c:if test="${req_page == null}">
			<img alt="라이언" src="../image/lion.jpg">
		</c:if>
		
		<c:if test="${req_page != null}">			
			<jsp:include page="${req_page}"/>			
		</c:if>
		</div>
	</div>
	
	<div id="footer">
		<p>EZEN IT ACADEMY</p>
	</div>
</body>
</html>






