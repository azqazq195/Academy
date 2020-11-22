<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	// 데이터 처리
	String localNum = request.getParameter("localNum");
	String result = "";
	
	switch(localNum) {
	case "0": result = "종로, 중구, 용산"; break;
	case "1": result = "도봉, 신사, 잠실"; break;
	case "2": result = "동대문, 성대, 안양"; break;
	case "3": result = "수원, 용인"; break;
	default: result = "없는 권역"; break;
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>선택하신 지역은 <b><%=result %></b> 입니다.</p>
</body>
</html>


