<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<table border="1" width="100%">
		<tr>
			<td colspan="2" align="center">
				<jsp:include page="../template/top.jsp"/>
			</td>
		</tr>
		
		<tr>
			<td width="270" height="400" valign="top">
				<jsp:include page="../template/left.jsp"/>
			</td>
			
			<td>
				<c:if test="${display==null}">
					<jsp:include page="../template/body.jsp"/>
				</c:if>
				
				<c:if test="${display!=null }">
					<jsp:include page="${display}"/>
				</c:if>
			</td>
		</tr>
		
		<tr>
			<td colspan="2">
				<jsp:include page="../template/bottom.jsp"/>
			</td>
		</tr>
	</table>
</body>
</html>






