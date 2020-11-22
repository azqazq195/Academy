<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/imageboardScript.js"></script>
</head>
<body>
	<h3>이미지 등록</h3>
 	<form action="../imageboard/imageboardWrite.jsp"  name="imageboardWriteForm"
		enctype="multipart/form-data" method="post">
<!-- 
	<form action="../main/index.jsp?req=imageboardWrite" 
		  enctype="multipart/form-data" method="post">
 -->
		<table border="1">
			<tr>
				<th width="100">상품코드</th>
				<td><input type="text" name="imageId" value="img_" size="50"></td>
			</tr>
			<tr>
				<th>상품명</th>
				<td><input type="text" name="imageName" size="50"></td>
			</tr>
			<tr>
				<th>단가</th>
				<td><input type="text" name="imagePrice" size="50"></td>
			</tr>
			<tr>
				<th>개수</th>
				<td><input type="text" name="imageQty" size="50"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="10" cols="53" name="imageContent"></textarea></td>
			</tr>
			<tr>				
				<td colspan="2"><input type="file" name="image1" size="50"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="이미지 등록"
							onclick="checkImageboardWrite()">
					<input type="reset" value="다시 작성">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>









