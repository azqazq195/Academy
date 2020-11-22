<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>         
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 목록 보기</title>

<style type="text/css">	
	#paging {color:black; text-decoration: none;}
	#currentPaging {color: black; text-decoration:none; font-weight: bold; font-size: 1.2em;}
	h2 {
	font-size: 1.7em;
	margin-left:20px;}
	table {margin-left:20px;}
	
</style>

</head>
<body>
	<h2>[도서 목록]</h2>
	<br>
	
	<table border="1">
		<tr bgcolor="#FFBB00">
			<th width="120">도서코드</th>
			<th width="170">도서명</th>
			<th width="150">저자</th>
			<th width="150">출판사</th>
			<th width="120">가격</th>
			<th width="150">출판일</th>
		</tr>
		
		<c:forEach var="dto" items="${list }">
			<tr align="center" bgcolor="#F6F6F6">
			<td>${dto.code}</td>
			<td>${dto.title}</td>
			<td>${dto.author}</td>
			<td >${dto.publisher}</td>
			<td >${dto.price}원</td>
			<td >${dto.publiDate}</td>
		</tr>
		</c:forEach>
		
		<!-- 페이징! -->
		<tr>
		<td colspan="6" align = "center" bgcolor="#FAED7D">
		<c:if test="${startPage > 3}">
			[<a id="paging" href="bookList.do?pg=${startPage-1 }">이전</a>]
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage }" step="1">
			<c:if test="${pg == i}">
				[<a id="currentPaging" href="bookList.do?pg=${i}">${i}</a>]
			</c:if>
			
			<c:if test="${pg != i}">
				[<a id="paging" href="bookList.do?pg=${i}">${i}</a>]
			</c:if>
		</c:forEach>	
			
		<c:if test="${endPage< totalPage}">
			[<a id="paging" href="bookList.do?pg=${endPage+1 }">다음</a>]
		</c:if>	
			
		</td>
	</tr>	
	<tr>
	</tr>	
	</table>
		
</body>
</html>