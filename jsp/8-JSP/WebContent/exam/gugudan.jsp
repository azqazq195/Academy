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
<% for(int x=2; x<=9; x++) {  // 단 : 2~9단 %>
	<tr>
<%	for(int y=1; y<=9; y++) { // 1~9 %>
		<td>&nbsp;<%=x %>*<%=y %>=<%=x*y %>&nbsp;</td>
<% 	} %>
	</tr>		
<% } %>
	</table>
</body>
</html>



