<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		width: 400px;
		height: 400px;
		text-align: center;
	}
	table, tr , td {
		border: 1px solid;
		
	}
	title {
		height: 100px;
	}
</style>
<script type="text/javascript" src="./javaScript/bookJs.js?v=25"></script>
</head>
<body>
	<form action="./book/InsertBookData.jsp" name="writeForm">
		<table>
			<tr>
				<td>도서 입력 화면</td>
			</tr>
			<tr><td id="title">도서코드 : <input type="text" name="bookCode" /></td></tr>
			<tr><td>도 서 명  : <input type="text" name="bookName" /></td>
			<tr><td>저      자 : <input type="text" name="artist" /></td>
			<tr><td>출 판 사  : <input type="text" name="publisher" /></td>
			<tr><td>도서가격 : <input type="text" name="bookPrice" /></td></tr>
			<tr><td><input type="button" onclick="check();" value="도서 등록"></td></tr>
		</table>
	</form>
</body>
</html>