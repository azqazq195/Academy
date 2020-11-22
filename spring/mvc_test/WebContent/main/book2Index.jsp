<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 관리 메인페이지</title>
<style type="text/css">
	* {
	margin:0;
	padding:0;
	}
	html, body {width:100%; height:100%; margin:0; padding:0; background: #FAECC5;}
	#header {height:17%; text-align: center; border-bottom: 3px solid #8C8C8C; 
			font-size: 1.1em; font-style: bold; 
			background: #F2CB61;
			}
	h1{padding: 45px 0 0 0;}	
	#container {height:73%;}
	#nav {height:100%; float:left; width:20%; background:#FFC19E; border-right:3px solid #8C8C8C; }
	#section {height:100%; float:left; }
	#footer {clear:both; height:10%;  text-align: center; border-top: 3px solid #8C8C8C; font-size: 1.2em; background: #F09661; font-family: sans-serif;}
	#img3 {margin:0 0 0 330px;}
	
	#main:link{color: black; text-decoration: none;}
	#main:visited{color: black; text-decoration: none;}
	#main:action{color: black; text-decoration: none;}
	#main:hover{color: #993800; text-decoration: underline;}
</style>

</head>
<body>
	<div id="header"><h1>도서 관리 프로그램</h1></div>
	<div id="container">
		<div id="nav" align="center">
			<br><br><br>
			<h3><a id="main" href="../main/book2Index.jsp">◀ 메인 화면 돌아가기</a></h3>
			<br>
			<p>_______________________________</p>
			<br>
			<p><a id="main" href="bookWriteForm.do">도서 입력 ▶</a></p>
			<p><a id="main" href="bookList.do">도서 목록보기 ▶</a></p>
		</div>
		<div id="section">
			<br><br><br>
			<c:if test="${req_page == null}">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<img alt="책" src="../image/library.PNG" width="400px">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<img alt="책2" src="../image/library2.PNG" width="400px">
				<br><br>
				<img alt="책3" src="../image/library3.PNG" width="250px" id="img3">
			</c:if>
			
			<c:if test="${req_page != null}">
				<jsp:include page="${req_page}"/>
			</c:if>
			
		</div>
	</div>
	<div id="footer">by SI, Hong ☺</div>
</body>
</html>