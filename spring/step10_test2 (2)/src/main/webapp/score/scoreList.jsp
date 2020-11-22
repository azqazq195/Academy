<%@page import="score.bean.ScoreDTO"%>
<%@page import="java.util.List"%>
<%@page import="score.dao.ScoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	// 목록 : 5개씩
	int endNum = pg * 5;
	int startNum = endNum - 4;
	
	ScoreDAO scoreDAO = new ScoreDAO();
	List<ScoreDTO> list = scoreDAO.getScoreList(startNum, endNum);
	
	// 페이징 : 3블럭
	int listCount = scoreDAO.selectListCount();  // 총 저장 데이터 수
	int maxPage = (listCount + 4) / 5;			 // 총 페이지 수
	int startPage = (pg-1)/3*3 + 1;
	int endPage = startPage + 2;
	if(endPage > maxPage) endPage = maxPage;
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 목록</title>
<style type="text/css">
#listForm {
	width: 500px;
	height: 160px;
	margin: auto;
}
h2 {text-align: center;}
table {
	margin: auto;
	width: 450px;
}
#tr_top {background: orange;}
#currentPaging {color: red; text-decoration: underline;}
#paging {color: blue; text-decoration: none;}

#name:link {color:black; text-decoration: none;}
#name:visited {color:black; text-decoration: none;}
#name:hover {color:green; text-decoration: underline;}
#name:action {color:black; text-decoration: none;}
</style>
</head>
<body>
	<h2>성적 목록</h2>
	<br>
	<div id="listForm">
		<table>
			<tr id="tr_top">
				<th>학번</th>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>
			</tr>
		
		<% for(ScoreDTO scoreDTO : list) { %>
			<tr bgcolor="ffffcc" align="center">
				<td><%=scoreDTO.getStudNo() %></td>
				<td><a id="name" href="scoreView.jsp?studNo=<%=scoreDTO.getStudNo()%>&pg=<%=pg%>">   
						<%=scoreDTO.getName() %></a></td>
				<td><%=scoreDTO.getKor() %></td>
				<td><%=scoreDTO.getEng() %></td>
				<td><%=scoreDTO.getMat() %></td>
				<td><%=scoreDTO.getTot() %></td>
				<td><%=scoreDTO.getAvg() %></td>
			</tr>
		<% } %>
		
			<tr>
				<td colspan="7" align="center">
		<% if(startPage > 3) { %>
					[<a id="paging" href="scoreList.jsp?pg=<%=startPage-1%>">이전</a>]
		<% } %>
					
		<% for(int i=startPage; i<=endPage; i++) { %>				
			<% if(pg == i) { // 현재 페이지%>
					[<a id="currentPaging" href="scoreList.jsp?pg=<%=i%>"><%=i%></a>]
			<% } else { %>
					[<a id="paging" href="scoreList.jsp?pg=<%=i%>"><%=i%></a>]
			<% } %>
		<% } %>
		
		<% if(endPage < maxPage) { %>
					[<a id="paging" href="scoreList.jsp?pg=<%=endPage+1%>">다음</a>]
		<% } %>
				</td>		
			</tr>
		</table>
		
		<a href="scoreWriteForm.jsp">성적 입력</a>
	</div>
</body>
</html>















