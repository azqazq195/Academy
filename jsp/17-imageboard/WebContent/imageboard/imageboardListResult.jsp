<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#paging {color: blue; text-decoration: none;}
#currentPaging {color: red; text-decoration: underline;}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<th width="50">번호</th>
			<th width="150">이미지</th>
			<th width="150">상품명</th>
			<th width="100">단가</th>
			<th width="100">개수</th>
			<th width="100">합계</th>
		</tr>
		<%--
			자바빈즈에 저장된 데이터를 el 표현식으로 사용하기
			${dto.변수명} => dto.get변수명();
			(예) ${dto.seq} => dto.getSeg();
		 --%>
	<c:forEach var="dto" items="${list}">
		<tr align="center">
			<td>${dto.seq}</td>
			<%--
				* 경로 표시
				1. 절대 경로
				http://localhost:8080/17-imageboard/storage/cupra.jpg
				2. 상대 경로
				../storage/cupra.jpg
			 --%>
			<td>
				<a href="../imageboard/imageboardView.jsp?seq=${dto.seq}&pg=${pg}">
				<img alt="이미지" src="../storage/${dto.image1}" 
						width="50" height="50"></a>
			</td>
			<td>${dto.imageName}</td>
			<td>${dto.imagePrice}</td>
			<td>${dto.imageQty}</td>
			<td>${dto.imagePrice * dto.imageQty}</td>
		</tr>
	</c:forEach>
		<tr>
			<td colspan="6" align="center">
			<c:if test="${startPage > 3}">
				[<a id="paging" href="../imageboard/imageboardList.jsp?pg=${startPage-1}">이전</a>]
			</c:if>	
				
			<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
				<c:if test="${pg==i}">
				[<a id="currentPaging" href="../imageboard/imageboardList.jsp?pg=${i}">${i}</a>]
				</c:if>
				
				<c:if test="${pg!=i}">
				[<a id="paging" href="../imageboard/imageboardList.jsp?pg=${i}">${i}</a>]
				</c:if>
			</c:forEach>	
				
			<c:if test="${endPage < totalP}">
				[<a id="paging" href="../imageboard/imageboardList.jsp?pg=${endPage+1}">다음</a>]
			</c:if>	
			</td>
		</tr>
	</table>
</body>
</html>












