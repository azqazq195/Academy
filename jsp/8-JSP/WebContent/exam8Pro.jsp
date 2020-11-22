<%@page import="java.util.regex.Pattern"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  // 데이터 처리
	String num1_str = request.getParameter("num1");
	String num2_str = request.getParameter("num2");
	String op = request.getParameter("op");
	String err_msg = "";
	double num1 = 0, num2 = 0;
	double result = 0;
	
	// 문자열을 숫자로 변환시킬 때는 반드시 입력 검사를 해야한다.
	// 1. 입력값이 있는 지 검사
	// 2. 입력값이 숫자로만 구성되었는 지 검사
	if(num1_str.equals("") || num2_str.equals("")) {
		err_msg = "입력값이 없습니다.";
	} else if(!num1_str.matches("^[0-9]+(.[0-9]+)?$") ||
			  !num2_str.matches("^[0-9]+(.[0-9]+)?$")){
		err_msg = "숫자만으로 입력을 해주세요1";
	} /*else if(!Pattern.matches("^[0-9]+(.[0-9]+)?$", num1_str) ||
			  !Pattern.matches("^[0-9]+(.[0-9]+)?$", num2_str)){
		err_msg = "숫자만으로 입력을 해주세요2";
	} */else {
		num1 = Double.parseDouble(num1_str);
		num2 = Double.parseDouble(num2_str);		
		
		switch(op) {
		case "+": result = num1 + num2; break;
		case "-": result = num1 - num2; break;
		case "*": result = num1 * num2; break;
		case "/": result = num1 / num2; break;
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(err_msg.equals("")) { %>
	<p><%=num1 %> <%= op %> <%=num2 %> = <%=result %></p>
<% } else { %>
	<p><%=err_msg %></p>
<% } %>
</body>
</html>



