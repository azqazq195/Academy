<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보</title>
</head>
<body>
	<h2>학번, 이름, 학년, 선택과목을 입력하는 폼</h2>
	<form action="exam1Pro.jsp">
		학번 : <input type="text" name="num"><br>
		이름 : <input type="text" name="name"><br>
		학년 : <input type="radio" name="grade" value="1" checked="checked">1학년 
			 <input type="radio" name="grade" value="2">2학년 
			 <input type="radio" name="grade" value="3">3학년 
			 <input type="radio" name="grade" value="4">4학년<br>
		선택과목: <select name="subject">
					<option value="Java">Java</option>
					<option value="JSP">JSP</option>
					<option value="Spring">Spring</option>
				</select><br>
		<input type="submit" value="입력 완료">
	</form>
</body>
</html>



