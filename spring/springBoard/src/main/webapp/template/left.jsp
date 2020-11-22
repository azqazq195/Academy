<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${memId == null}">
	<jsp:include page="../member/loginForm.jsp"/>
</c:if>

<c:if test="${memId != null}">
	<jsp:include page="../member/loginOk.jsp"/>
	<hr>
	<a href="../board/boardWriteForm.do">글쓰기</a><br>
	<a href="../member/logout.do">로그아웃</a><br>
	<a href="../member/modifyForm.do">회원정보수정</a><br>
	<a href="../member/memberList.do?pg=1">회원목록보기</a><br>	
	<a href="../member/deleteForm.do">회원탈퇴</a><br>
</c:if>
<a href="../board/boardList.do?pg=1">글목록</a><br>












