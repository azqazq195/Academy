<%@page import="score.bean.ScoreDTO"%>
<%@page import="score.dao.ScoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	// 데이터
	String studNo = request.getParameter("studNo");
	int pg = Integer.parseInt(request.getParameter("pg"));
	// DB
	ScoreDAO scoreDAO = new ScoreDAO();
	ScoreDTO dto = new ScoreDTO();
	dto.setStudNo(studNo);
	
	dto = scoreDAO.getScore(dto);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 보기</title>
<style type="text/css">
tr {
	background: #ffffcc;
}
#tr_top {
	background: orange;
	text-align: center;
}
</style>
</head>
<body>
	<table border="1">
		<tr id="tr_top">
			<td colspan="6">
				<font size="5"><%=dto.getName() %></font>
			</td>
		</tr>
		
		<tr align="center">
			<td width="100">학번</td>
			<td width="100">국어</td>
			<td width="100">영어</td>
			<td width="100">수학</td>
			<td width="100">총점</td>
			<td width="100">평균</td>
		</tr>
		
		<tr align="center">
			<td width="100"><%=dto.getStudNo() %></td>
			<td width="100"><%=dto.getKor() %></td>
			<td width="100"><%=dto.getEng() %></td>
			<td width="100"><%=dto.getMat() %></td>
			<td width="100"><%=dto.getTot() %></td>
			<td width="100"><%=dto.getAvg() %></td>
		</tr>
	</table>
	
	<input type="button" value="목록" 
		onclick="location.href='scoreList.jsp?pg=<%=pg%>'">
	<input type="button" value="성적 수정" onclick="">
	<input type="button" value="성적 삭제" 
		onclick="location.href='scoreDelete.jsp?studNo=<%=studNo%>'">
</body>
</html>







