<%@page import="book.dto.BookDTO"%>
<%@page import="book.dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BookDTO bookDTO = new BookDTO();
	bookDTO.setBookCode(Integer.parseInt(request.getParameter("bookCode")));
	bookDTO.setBookName(request.getParameter("bookName"));
	bookDTO.setArtist(request.getParameter("artist"));
	bookDTO.setPublisher(request.getParameter("publisher"));
	bookDTO.setBookPrice(Integer.parseInt(request.getParameter("bookPrice")));
	
	BookDAO bookDAO = new BookDAO();
	
	int result = bookDAO.insertArticle(bookDTO);
	
	response.sendRedirect("../index.jsp?req=Success&result=" + result);
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