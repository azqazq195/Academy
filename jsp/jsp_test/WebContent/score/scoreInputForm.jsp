<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 입력</title>
<script type="text/javascript" src="../script/score.js"></script>
</head>
<body>
	<form action="scoreInput.jsp" method="post" name="scoreInputForm">
		<table border="1">
			<tr>
				<td width="50" align="center">학번</td>
				<td><input type="text" name="hak" size="29"></td>
			</tr>
			<tr>
				<td align="center">이름</td>
				<td><input type="text" name="name" size="29"></td>
			</tr>
			<tr>
				<td align="center">국어</td>
				<td><input type="text" name="kor" size="29"></td>
			</tr>
			<tr>
				<td align="center">영어</td>
				<td><input type="text" name="eng" size="29"></td>
			</tr>
			<tr>
				<td align="center">수학</td>
				<td><input type="text" name="mat" size="29"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="점수입력" onclick="check()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>