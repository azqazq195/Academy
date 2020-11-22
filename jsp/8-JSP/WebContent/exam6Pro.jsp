<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 한글 처리
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String local = request.getParameter("local");
	String tel = request.getParameter("tel");
	String local_num = "";
	
	switch(local) {
	case "서울": local_num = "02"; break;
	case "경기": local_num = "031"; break;
	case "인천": local_num = "032"; break;
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=name %>님의 전화번호는 <%=local_num %>-<%=tel %> 입니다.
</body>
</html>



