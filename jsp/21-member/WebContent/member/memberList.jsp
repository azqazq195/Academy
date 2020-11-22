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
		<tr style="background: orange;">
			<th width="50">이름</th>
			<th width="100">아이디</th>
			<th width="50">성별</th>
			<th width="150">이메일</th>
			<th width="150">전화번호</th>
			<th width="150">가입일</th>
		</tr>
		
	<c:forEach var="memberDTO" items="${list}">
		<tr align="center">
			<td>${memberDTO.name}</td>
			<td>${memberDTO.id}</td>
			<td>
			<c:if test="${memberDTO.gender == '0'}">
				남자
			</c:if>
			
			<c:if test="${memberDTO.gender != '0'}">
				여자
			</c:if>			
			</td>
			<td>${memberDTO.email1}@${memberDTO.email2}</td>
			<td>${memberDTO.tel1}-${memberDTO.tel2}-${memberDTO.tel3}</td>
			<td>${memberDTO.logtime}</td>
		</tr>
	</c:forEach>
	
	
		<!-- 페이징 -->
		<tr>
			<td colspan="6" align="center">
		<c:if test="${startPage > 3}">
				[<a id="paging" href="memberList.do?pg=${startPage-1}">이전</a>]
		</c:if>
			
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
			<c:if test="${pg == i}">
				[<a id="currentPaging" href="memberList.do?pg=${i}">${i}</a>]
			</c:if>
			
			<c:if test="${pg != i}">
				[<a id="paging" href="memberList.do?pg=${i}">${i}</a>]
			</c:if>
		</c:forEach>		
			
		<c:if test="${endPage < totalP}">
			[<a id="paging" href="memberList.do?pg=${endPage+1}">다음</a>]
		</c:if>		
			</td>
		</tr>
	</table>
	
	<a href="../main/index.jsp">메인화면</a>
</body>
</html>









