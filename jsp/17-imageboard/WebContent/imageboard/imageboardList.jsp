<%@page import="imageboard.bean.ImageboardDTO"%>
<%@page import="java.util.List"%>
<%@page import="imageboard.dao.ImageboardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터
	int pg = Integer.parseInt(request.getParameter("pg"));

	// DB
	// 목록 : 1 페이지당 5개씩
	int endNum = pg * 5;
	int startNum = endNum - 4;
	
	ImageboardDAO imageboardDAO = new ImageboardDAO();
	List<ImageboardDTO> list = imageboardDAO.imageboardList(startNum, endNum);
	
	// 페이징 처리
	// 총글수 : 38
	// 총페이수 : 8
	// 		[1][2][3][다음]
	// [이전][4][5][6][다음]
	// [이전][7][8]
	int totalA = imageboardDAO.getTotalA(); // 총글수
	int totalP = (totalA + 4) / 5; 			// 총페이지수
	
	int startPage = (pg-1)/3*3 + 1;
	int endPage = startPage + 2;
	if(endPage > totalP) endPage = totalP;
	
	// 화면 이동
	// 1. 데이터 공유
	request.setAttribute("pg", pg);
	request.setAttribute("list", list);
	request.setAttribute("totalP", totalP);
	request.setAttribute("startPage", startPage);
	request.setAttribute("endPage", endPage);
	// 2. 화면 이동
	RequestDispatcher dispatcher = 
		request.getRequestDispatcher("../main/index.jsp?req=imageboardListResult");
	dispatcher.forward(request, response);
%>





