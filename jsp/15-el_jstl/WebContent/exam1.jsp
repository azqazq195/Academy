<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 표현식</title>
</head>
<body>
	<table border="1" width="600">
		<tr>
			<th width="200">표현식</th>
			<th width="200">값</th>
			<th>jsp 표현식</th>
		</tr>
		<tr align="center"">
			<td>\${25+36}</td>
			<td>${25+36}</td>
			<td><%=25+36%></td>
		</tr>
		<tr align="center"">
			<td>\${25/6}</td>
			<td>${25/6}</td>
			<td><%=25/6%></td>
		</tr>
		<tr align="center"">
			<td>\${25%6}</td>
			<td>${25%6}</td>
			<td><%=25%6%></td>
		</tr>
		<tr align="center"">
			<td>\${25>36}</td>
			<td>${25>36}</td>
			<td><%=25>36%></td>
		</tr>
		<tr align="center"">
			<td>\${header['host']}</td>
			<td>${header['host']}</td>
		</tr>
		<tr align="center"">
			<td>\${header.host}</td>
			<td>${header.host}</td>
		</tr>
	</table>
</body>
</html>









