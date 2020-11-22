<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	// 데이터 처리
	// 한글 설정
	request.setCharacterEncoding("UTF-8");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	String id = (String) session.getAttribute("memId");
	String name = (String) session.getAttribute("memName");

	// DB
	BoardDTO boardDTO = new BoardDTO();
	boardDTO.setName(name);
	boardDTO.setId(id);
	boardDTO.setSubject(subject);
	boardDTO.setContent(content);
	
	BoardDAO boardDAO = new BoardDAO();
	int su = boardDAO.boardWrite(boardDTO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(<%=su > 0%>) {
		alert("작성하신 글을 저장하였습니다.");
		location.href = "boardList.jsp?pg=1";
	} else {
		alert("작성하신 글을 저장하지 못하였습니다.");
		location.href = "boardWriteForm.jsp";
	}
</script>
</head>
<body>

</body>
</html>









