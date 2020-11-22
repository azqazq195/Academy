<%@page import="score.DAO.ScoreDAO"%>
<%@page import="java.util.List"%>
<%@page import="score.bean.ScoreDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int pg = Integer.parseInt(request.getParameter("pg"));

	int end = pg * 10;
	int start = end - 9;
	
	ScoreDAO dao = new ScoreDAO();
	List<ScoreDTO> list = dao.scorelist(start, end);
	
	int totA = dao.getTotA();
	int totP = (totA + 9) / 10;
	
	int startP = (pg-1)/3 * 3 + 1;
	int endP = startP + 2;
	if(endP > totP) endP = totP;
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#subjectA:link {color: black; text-decoration: none;}
#subjectA:visited {color: black; text-decoration: none;}
#subjectA:hover {color: green; text-decoration: underline;}
#subjectA:active {color: black; text-decoration: none;}

#paging {color: blue; text-decoration: none;}
#currentPaging {color: red; text-decoration: underline;}
</style>
</head>
<body>
	<table border="1">
		<tr bgcolor="ff4400">
			<th width="70">학번</th>
			<th width="100">이름</th>
			<th width="70">국어</th>
			<th width="70">영어</th>
			<th width="70">수학</th>
			<th width="70">총점</th>
			<th width="70">평균</th>	
		</tr>
		<%for(ScoreDTO dto : list){ %>
		<tr align="center" bgcolor="mistyrose">
        	<td><%=dto.getHak() %></td>
      		<td><%=dto.getName()%></td>
      		<td><%=dto.getKor()%></td>
      		<td><%=dto.getEng()%></td>
      		<td><%=dto.getMat()%></td>
      		<td><%=dto.getTot()%></td>
         	<td><%=String.format("%.1f", dto.getAvg())%></td>
      </tr>   
   <%} %>	
   		<tr>
			<td colspan="7" align="center">
			<%if(startP > 3) {%>
				[<a href="scoreList.jsp?pg=<%=startP-1%>">이전</a>]
			<%} %>
				
			<% for(int i=startP; i<=endP; i++) {%>	
				<%if(pg == i) { //현재페이지%>
					[<a id="currentPaging" href="scoreList.jsp?pg=<%=i%>"><%=i %></a>]
				<% } else { 	//현재 페이지 아님 %>	
					[<a id="paging" href="scoreList.jsp?pg=<%=i%>"><%=i %></a>]
				<%} %>
			<%} %>
			
			<% if(endP < totP) {%>	
				[<a href="scoreList.jsp?pg=<%=endP+1%>">다음</a>]
			<% } %>	
			</td>
		</tr>		
	</table>
	[<a href="scoreInputForm.jsp">점수입력하러가기</a>]
</body>
</html>