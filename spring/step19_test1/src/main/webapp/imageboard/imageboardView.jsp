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
		<tr align="center">
			<td rowspan="4" width="150">
				<img alt="" src="../storage/${imageboardDTO.image1}" width="150" height="150">
			</td>
			<td width="100">상품명</td>
			<td width="100">${imageboardDTO.imageName}</td>
		</tr>
		
		<tr align="center">
			<td>단가</td>
			<td>${imageboardDTO.imagePrice}</td>
		</tr>
		<tr align="center">
			<td>개수</td>
			<td>${imageboardDTO.imageQty}</td>
		</tr>
		<tr align="center">
			<td>합계</td>
			<td>${imageboardDTO.imagePrice * imageboardDTO.imageQty}</td>
		</tr>
		<tr>			
			<td colspan="3" height="200" valign="top"><pre>${imageboardDTO.imageContent}</pre></td>
		</tr>
		
		<tr>
			<td colspan="3" align="center">
				<input type="button" value="목록" onclick="location.href='imageboardList?pg=${pg}'">
				<input type="button" value="수정" onclick="">
				<input type="button" value="삭제" 
					onclick="location.href='imageboardDelete?seq=${seq}&pg=${pg}'">
			</td>
		</tr>
	</table>
</body>
</html>










