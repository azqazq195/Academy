<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#articleForm {
	width: 500px;
	height: 500px;
	border: 1px solid lightgray;
	margin: auto;
}
h2 {
	text-align: center;
}
#basicInfoArea {
	height: 40px;
	text-align: center;
}
#articleContentArea {
	background: orange;
	margin-top: 20px;
	height: 350px;
	text-align: center;
	overflow: auto;
}
#commandList {
	margin: auto;
	width: 500px;
	text-align: center;
}
</style>
</head>
<body>
	<div id="articleForm">
		<h2>글 내용 상세보기</h2>
		<div id="basicInfoArea">
			제목 : ${boardBean.board_subject} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			첨부파일 : 
				<c:if test="${boardBean.board_file != null}">
					<a href="fileDown.do?downFile=${boardBean.board_file}">${boardBean.board_file}</a>
				</c:if>
		</div>
		<div id="articleContentArea">
			<pre>${boardBean.board_content}</pre>
		</div>
		<div id="commandList">
			<a href="boardReplyForm.do?board_num=${boardBean.board_num}&page=${page}">[답변]</a>
			<a href="boardModifyForm.do?board_num=${boardBean.board_num}&page=${page}">[수정]</a>
			<a href="boardDeleteForm.do?board_num=${boardBean.board_num}&page=${page}">[삭제]</a>
			<a href="boardList.do?page=${page}">[목록]</a>
		</div>
	</div>
</body>
</html>




