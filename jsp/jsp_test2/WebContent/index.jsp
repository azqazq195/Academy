<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
	body { 
		width: 1000px;
		border: 0;
		margin: 0 auto;
	}
	
	#header {
		border-bottom: 1px solid;
	}
	
	#body {
		width: 1000px;
		height: 800px;
	}
	
	#nav {
		width: 200px;
		height: 800px;
		background: orange;
		float: left;
	}
	
	#section {
		width: 800px;
		height: 800px;
		float: left;
	}
	#footer {
		background: mistyrose;
		height: 100px;
		clear: both;
	}
	
	#main:link {
		color: black;
		text-decoration: none;
	}
	#main:visited {
		color: black;
		text-decoration: none;
	}
	#main:action {
		color: black;
		text-decoration: none;
	}
	#main:hover {
		color: black;
		text-decoration: none;
	}
</style>
</head>
<body>
	<div id="header" align="center">
		<c:if test="${param.req == null }">
			<h1>*** 메인 화면 ***</h1>
		</c:if>
		<c:if test="${param.req == 'insertBook' }">
			<h1>*** 도서 정보 입력 ***</h1>
		</c:if>		
		<c:if test="${param.req == 'bookListResult' }">
			<h1>*** 전체  도서 목록 ***</h1>
		</c:if>		
	</div>
	
	<div id="body">
		<div id="nav" align="center">
			<h3><a id="main" href="/jsp_test2/index.jsp">*** 메인화면 ***</a></h3>
			<a href="/jsp_test2/index.jsp?req=insertBook">도서입력 화면</a><br>
			<a href="/jsp_test2/book/bookList.jsp?pg=1">전체 도서 목록</a>
			
		</div>
	
		<div id="section">
			<c:if test="${param.req == null }">
				메인화면이에영 메뉴에서 원하시는 내용을 탭해주세요.
			</c:if>
			<c:if test="${param.req == 'insertBook' }">
				<jsp:include page="./book/InsertBook.jsp"></jsp:include>
			</c:if>
			<c:if test="${param.req == 'Success' }">
				<jsp:include page="./book/uploadBookView.jsp?result=${param.result }"></jsp:include>
			</c:if>
			<c:if test="${param.req == 'bookListResult' }">
				<jsp:include page="./book/bookListResult.jsp"></jsp:include>
			</c:if>
		</div>
	</div>
	
	<div id="footer" align="center">
		&copy;이인제작품!
	</div>
</body>
</html>