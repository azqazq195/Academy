<%@page import="board.bean.BoardDTO"%>
<%@page import="board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	// 데이터
	request.setCharacterEncoding("utf-8");  // 한글 엔코딩 설정
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	// DB
	BoardDTO boardDTO = new BoardDTO();
	boardDTO.setSubject(subject);
	boardDTO.setContent(content);
	boardDTO.setSeq(seq);
	
	BoardDAO boardDAO = new BoardDAO();
	int su = boardDAO.boardModify(boardDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(<%=su > 0%>) {
		alert("글수정 성공");
	} else {
		alert("글수정 실패")
	}
	location.href = "boardView.jsp?seq=<%=seq%>&pg=<%=pg%>";
</script>
</head>
<body>

</body>
</html>







