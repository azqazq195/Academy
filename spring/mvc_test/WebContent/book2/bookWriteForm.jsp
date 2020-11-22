<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 입력 페이지</title>
<script type="text/javascript" src="../script/book2Script.js"></script>
<style type="text/css">
	h2 {font-size: 1.7em; margin-left:20px;}
	table {margin-left:20px;}
	
	#col {background: #FFBB00; font-weight: bold;}
	
	#box {background: #F6F6F6;	}
</style>
</head>
<body>
	
	<form action="bookWrite.do" name="bookWriteForm" method="post">
		<h2>[도서 입력]</h2>
			<br>
		<table border="1" bgcolor="#FAED7D">
			<tr >
			<td id="col" align="center" width="100">도서코드</td>
			<td><input type="text" name="code" value="BC_" size="50" id="box"></td>
			</tr>
			<tr>
			<td id="col" align="center" width="100">도서명</td>
			<td><input type="text" name="title" size="50" id="box"></td>
			</tr>
			<tr>
			<td id="col" align="center" width="100">저자</td>
			<td><input type="text" name="author" size="50" id="box"></td>
			</tr>
			<tr>
			<td id="col" align="center" width="100">출판사</td>
			<td><input type="text" name="publisher" size="50" id="box"></td>
			</tr>
			<tr>
			<td id="col" align="center" width="100">가격</td>
			<td><input type="text" name="price" size="50" id="box"></td>
			</tr>
			<tr>
			<td id="col" align="center" width="100">출판일</td>
			<td><input type="text" name="publiDate" size="50" placeholder="2020-09-21" id="box"></td>
			</tr>
			
			<tr>
			<td colspan="2" align="center" width="100" height=40">
				<input type="button" value="  도서 등록하기  " onclick="checkWrite()">
				&nbsp;
				<input type="reset" value="  다시 작성하기  ">
			</td>
			
			</tr>
		</table>
	
	</form>
</body>
</html>