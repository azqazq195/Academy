<%@page import="score.dao.ScoreDAO"%>
<%@page import="score.bean.ScoreDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	// 데이터
	request.setCharacterEncoding("UTF-8");	// 한글 설정
	String studNo = request.getParameter("studNo");
	String name = request.getParameter("name");
	int kor = Integer.parseInt(request.getParameter("kor"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	int mat = Integer.parseInt(request.getParameter("mat"));
	int tot = kor + eng + mat;
	double avg = (double)tot / 3;
	
	// DB
	ScoreDTO dto = new ScoreDTO();
	dto.setStudNo(studNo);
	dto.setName(name);
	dto.setKor(kor);
	dto.setEng(eng);
	dto.setMat(mat);
	dto.setTot(tot);
	dto.setAvg(avg);
	
	
	ScoreDAO scoreDAO = new ScoreDAO();
	int result = scoreDAO.insertScore(dto);	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(<%=result > 0%>) {
		alert("작성하신 성적을 저장하였습니다.")
		location.href = "scoreList.jsp?pg=1";
	} else {
		alert("작성하신 성적을 저장하지 못하였습니다.")
		location.href = "scoreWriteForm.jsp";
	}
</script>
</head>
<body>

</body>
</html>




