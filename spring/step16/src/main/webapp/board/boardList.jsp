<%@page import="board.bean.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록보기</title>
<style type="text/css">
#paging {color: blue; text-decoration: none;}
#currentPaging {color: red; text-decoration: underline;}

#subjectA:link {color: black; text-decoration: none;}
#subjectA:visited {color: black; text-decoration: none;}
#subjectA:hover {color: green; text-decoration: underline;}
#subjectA:active {color: black; text-decoration: none;}
</style>

<script type="text/javascript">
	function isLogin(seq) {
		if(${sessionScope.memId == null}) {
			alert("먼저 로그인 하세요.");
		} else {
			location.href = "boardView.do?seq=" + seq + "&pg=" + ${requestScope.pg};
		}		
	}
</script>
</head>
<body>
	<table border="1">
		<tr bgcolor="ffff00">
			<th width="70">글번호</th>
			<th width="200">제목</th>
			<th width="100">작성자</th>
			<th width="100">작성일</th>
			<th width="70">조회수</th>
		</tr>
	<c:forEach var="boardDTO" items="${list}">
		<tr align="center">
			<td>${boardDTO.seq}</td>
			<td><a id="subjectA" href="#" onclick="isLogin(${boardDTO.seq})">
				${boardDTO.subject}</a></td>
			<td>${boardDTO.id}</td>
			<td>${boardDTO.logtime}</td>
			<td>${boardDTO.hit}</td>
		</tr>
	</c:forEach>
	
	
		<tr>
			<td colspan="5" align="center">
		<c:if test="${startPage > 3}">
				[<a id="paging" href="boardList.do?pg=${startPage-1}">이전</a>]	
		</c:if>	
		
		<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1">
			<c:if test="${pg==i}">
				[<a id="currentPaging" href="boardList.do?pg=${i}">${i}</a>]
			</c:if>
			
			<c:if test="${pg!=i}">
				[<a id="paging" href="boardList.do?pg=${i}">${i}</a>]
			</c:if>
		</c:forEach>		
		
		<c:if test="${endPage < totalP}">
				[<a id="paging" href="boardList.do?pg=${endPage+1}">다음</a>]
		</c:if>			
			</td>
		</tr>
	</table>
	<br>
	<a href="boardWriteForm.do">새글 쓰기</a>
</body>
</html>















