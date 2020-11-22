<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	// 데이터 처리
	String x_str = request.getParameter("x");
	String y_str = request.getParameter("y");
	String err_msg = "";
	double x=0, y=0;
	
	// 입력값이 있는지, 숫자로 구성되었는지 검사
	if(x_str.equals("") || y_str.equals("")) {  // 입력값이 있는지 검사
		err_msg = "입력값이 없습니다.";
	} else if(!x_str.matches("^[0-9]+(.[0-9]+)?$") || 
			  !y_str.matches("^[0-9]+(.[0-9]+)?$")) {  // 숫자로 구성되었는 지 검사
		err_msg = "숫자로만 입력을 해주세요.";
	} else {
		x = Double.parseDouble(x_str);
		y = Double.parseDouble(y_str);
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=x %> + <%=y %> = <%=String.format("%.2f", x+y) %><br>
<%=x %> - <%=y %> = <%=String.format("%.2f", x-y) %><br>
<%=x %> * <%=y %> = <%=String.format("%.2f", x*y) %><br>
<%=x %> / <%=y %> = <%=String.format("%.2f", x/y) %><br>
</body>
</html>








