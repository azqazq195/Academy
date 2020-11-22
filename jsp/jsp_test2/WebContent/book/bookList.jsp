<%@page import="book.dto.BookDTO"%>
<%@page import="java.util.List"%>
<%@page import="book.dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int pg = 1;
	if(!request.getParameter("pg").equals("") && request.getParameter("pg") != null) {
		pg = Integer.parseInt(request.getParameter("pg"));
	}

	int endNum = pg * 10;
	int startNum = endNum - 9;

	BookDAO bookDAO = new BookDAO();
	List<BookDTO> list = bookDAO.selectArticleList(startNum, endNum);

 
 	int totalBook = bookDAO.selectListCount(); 
 	int totalListPage = (totalBook + 9)/10;
       
 	int startPage = (pg-1)/3*3 +1;       
 	int endPage = startPage + 2;
 	if(endPage > totalListPage) endPage = totalListPage;
 	
 	// 데이터 공유
 	request.setAttribute("pg", pg);
 	request.setAttribute("list", list);
 	request.setAttribute("totalListPage", totalListPage);
 	request.setAttribute("startPage", startPage);
 	request.setAttribute("endPage", endPage);
 	
 	RequestDispatcher dispatcher = request.getRequestDispatcher("../index.jsp?req=bookListResult");
 	dispatcher.forward(request, response);
%>
