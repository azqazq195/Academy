<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<font color="orange"><b>
		exam2.jsp -> send.jsp -> sendResult.jsp 페이지 이동합니다.<br>
		sendRedirect로 이동하므로 request 객체의 데이터는 공유하지 않습니다.<br>
		주소는 sendResult.jsp가 보입니다.
	</b></font>
	<hr>
	
	<font color="blue"><b>
		exam2.jsp -> forward.jsp -> forwardResult.jsp 페이지 이동합니다.<br>
		forward로 이동하므로 request 객체의 데이터는 공유합니다.<br>
		주소는 forward.jsp가 보이지만, 결과는 forwardResult.jsp가 보입니다.
	</b></font>
	<hr>
	
	<input type="button" value="sendRedirect" onclick="location.href='send.jsp'">
	<input type="button" value="forward" onclick="location.href='forward.jsp'">
</body>
</html>












