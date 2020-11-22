<%@page import="imageboard.dao.ImageboardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	// DB
	ImageboardDAO imageboardDAO = new ImageboardDAO();
	int su = imageboardDAO.imageboardDelete(seq);
	// 화면 네비게이션
	// 데이터 공유
	request.setAttribute("su", su);
	request.setAttribute("pg", pg);
	// 화면 이동
	RequestDispatcher dispatcher = 
		request.getRequestDispatcher("../main/index.jsp?req=imageboardDeleteResult");
	dispatcher.forward(request, response);
%>    
