<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	int su = (int) request.getAttribute("su");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(<%=su > 0%>) {
		alert("작성하신 글을 저장하였습니다.");
		location.href = "boardList.do?pg=1";
	} else {
		alert("작성하신 글을 저장하지 못하였습니다.");
		location.href = "boardWriteForm.do";
	}
</script>
</head>
<body>

</body>
</html>









