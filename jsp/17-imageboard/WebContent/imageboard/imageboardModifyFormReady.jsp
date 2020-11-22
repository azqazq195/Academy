<%@page import="imageboard.bean.ImageboardDTO"%>
<%@page import="imageboard.dao.ImageboardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	// DB
	ImageboardDAO imageboardDAO = new ImageboardDAO();
	ImageboardDTO dto = imageboardDAO.imageboardView(seq);
	
	// 화면 네비게이션
	// 데이터 공유
	request.setAttribute("seq", seq);
	request.setAttribute("pg", pg);
	request.setAttribute("dto", dto);
	// 화면 이동
	RequestDispatcher dispatcher 
		= request.getRequestDispatcher("../main/index.jsp?req=imageboardModifyForm");
	dispatcher.forward(request, response);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>



