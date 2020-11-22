<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>이름과 전화번호를 입력하세요</h2>
	<form action="exam6Pro.jsp" method="post">
		이름 : <input type="text" name="name"><br>
		전화번호 : <select name="local">
			<option value="서울">서울</option>
			<option value="경기">경기</option>
			<option value="인천">인천</option>
		</select> - 
		<input type="text" name="tel"><br>
		<input type="submit" value="제출">
		<input type="reset" value="다시 작성">	
	</form>
</body>
</html>




