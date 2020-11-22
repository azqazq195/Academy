<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 등록 결과</title>
</head>
<body>
	<c:if test="${su>0 }">
	  &nbsp;&nbsp; "${title}"의 정보가 성공적으로 입력되었습니다.
	</c:if>
	
	<c:if test="${su==0 }">
	  &nbsp;&nbsp; "${title}" 입력 실패!!
	</c:if>
	
</body>
</html>