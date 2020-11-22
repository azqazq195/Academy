<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	int seq = (int) request.getAttribute("seq");
	int pg = (int) request.getAttribute("pg");
	BoardDTO boardDTO = (BoardDTO) request.getAttribute("boardDTO");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글보기</title>
</head>
<body>
	<table border="1">
		<tr>
			<td colspan="3"><font size="5"><%=boardDTO.getSubject()%></font></td>
		</tr>
		<tr align="center">
			<td width="150">글번호 : <%=boardDTO.getSeq()%></td>
			<td width="150">작성자 : <%=boardDTO.getName()%></td>
			<td width="150">조회수 : <%=boardDTO.getHit()%></td>
		</tr>
		<tr>
			<td colspan="3" height="200" valign="top">
				<pre><%=boardDTO.getContent() %></pre>
			</td>
		</tr>
	</table>
	
	<input type="button" value="목록" onclick="location.href='boardList.do?pg=<%=pg%>'">
<% if(session.getAttribute("memId").equals(boardDTO.getId())) { %>	
	<input type="button" value="글수정" onclick="">
	<input type="button" value="글삭제" 
		onclick="location.href='boardDelete.do?seq=<%=seq%>&pg=<%=pg%>'">
<% } %>
</body>
</html>

















