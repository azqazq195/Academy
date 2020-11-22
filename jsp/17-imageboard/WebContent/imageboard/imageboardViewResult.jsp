<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td rowspan="4" width="150">
				<img alt="이미지" src="../storage/${dto.image1}" width="150" height="150">
			</td>
			<td width="200">상품명 : ${dto.imageName}</td>
		</tr>
		<tr>
			<td>단 가 : ${dto.imagePrice}</td>
		</tr>
		<tr>
			<td>개 수 : ${dto.imageQty}</td>
		</tr>
		<tr>
			<td>합 계 : ${dto.imagePrice * dto.imageQty}</td>
		</tr>
		<tr>
			<td colspan="2" height="200" valign="top">
				<pre>${dto.imageContent}</pre>
			</td>
		</tr>
	</table>
	<input type="button" value="목록" 
		onclick="location.href='../imageboard/imageboardList.jsp?pg=${pg}'">
	<input type="button" value="삭제" 
		onclick="location.href='../imageboard/imageboardDelete.jsp?seq=${seq}&pg=${pg}'">
	<input type="button" value="수정" 
		onclick="location.href='../imageboard/imageboardModifyFormReady.jsp?seq=${seq}&pg=${pg}'">
</body>
</html>







