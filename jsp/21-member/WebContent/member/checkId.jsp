<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkIdClose() {
		// opener 내장 객체 : 현재 브라우저 기준으로 부모 브라우저를 관리하는 객체
		opener.writeForm.id.value = "${id}";
		window.close();
		opener.writeForm.pwd.focus();
	}
	// 입력값 검사
	function checkId() {
		var frm = document.checkIdForm; // form 객체 생성
		if(!frm.id.value) {
			alert("아이디를 입력해주세요.");
			frm.id.focus();
		} else {
			frm.submit();
		}
	}
</script>
</head>
<body>
	<form action="memberCheckId.do" method="post" name="checkIdForm">
	<%-- // true : 사용불가 --%>
	<c:if test="${exist}">
		${id}는 사용 중 입니다.<br><br>
		아이디 <input type="text" name="id">
			 <input type="button" value="중복 체크" onclick="checkId()">  
	</c:if>
	
	<%-- // false : 사용가능 --%>
	<c:if test="${!exist}">
		${id}는 사용 가능합니다.<br><br>
		<input type="button" value="사용" onclick="checkIdClose()">
	</c:if>
	</form>
</body>
</html>





