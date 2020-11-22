<%@page import="score.DAO.ScoreDAO"%>
<%@page import="score.bean.ScoreDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	request.setCharacterEncoding("utf-8");
	int hak = Integer.parseInt(request.getParameter("hak"));
	String name = request.getParameter("name");
	int kor = Integer.parseInt(request.getParameter("kor"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	int mat = Integer.parseInt(request.getParameter("mat"));
	
	int tot = kor + eng + mat;
	double avg = (double)tot/3;
	
	//타오 저장
	ScoreDTO dto = new ScoreDTO();
	dto.setHak(hak);
	dto.setName(name);
	dto.setKor(kor);
	dto.setEng(eng);
	dto.setMat(mat);
	dto.setTot(tot);
	dto.setAvg(avg);
	
	ScoreDAO dao = new ScoreDAO();
	int su = dao.input(dto);

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	<% if(su > 0) { %>
		alert("입력 완료");
	<%} else { %>
		alert("입력 실패");
	<% } %>
	location.href = "../score/scoreList.jsp?pg=1";
</script>
</head>
<body>
	
</body>
</html>