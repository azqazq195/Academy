<%@page import="score.bean.ScoreDTO"%>
<%@page import="score.dao.ScoreDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	// 데이터
	String studNo = request.getParameter("studNo");
	// DB
	ScoreDAO scoreDAO = new ScoreDAO();
	ScoreDTO dto = new ScoreDTO();
	dto.setStudNo(studNo);
	
	int su = scoreDAO.deleteScore(dto);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(<%=su > 0%>) {
		alert("삭제 성공");
	} else {
		alert("삭제 실패");
	}
	location.href = "scoreList.jsp?pg=1";
</script>
</head>
<body>

</body>
</html>





