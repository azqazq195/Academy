<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC 게시판</title>
<style type="text/css">
#registForm {
	width: 500px;
	height: 380px;
	border: 1px solid lightgray;
	margin: auto;
}
h2 {
	text-align: center;
}
table {
	margin: auto;
	width: 450px;
}
.td_left {
	width: 150px;
	background: orange;
}
.td_right {
	width: 300px;
	background: skyblue;
}
</style>
</head>
<body>
	<h2>게시판 답글 등록</h2>
	<form action="boardReplyPro.do" method="post" name="boardform" id="registForm">
		<input type="hidden" name="page" value="${page}">
		<input type="hidden" name="board_num" value="${boardBean.board_num}">
		<input type="hidden" name="board_re_ref" value="${boardBean.board_re_ref}">
		<input type="hidden" name="board_re_lev" value="${boardBean.board_re_lev}">
		<input type="hidden" name="board_re_seq" value="${boardBean.board_re_seq}">
		
		<table>
			<tr>
				<td class="td_left"><label for="board_name">글쓴이</label></td>
				<td class="td_right">
					<input type="text" name="board_name" id="board_name" required="required">
				</td>
			</tr>
			<tr>
				<td class="td_left"><label for="board_pass">비밀번호</label></td>
				<td class="td_right">
					<input type="password" name="board_pass" id="board_pass" required="required">
				</td>
			</tr>
			<tr>
				<td class="td_left"><label for="board_subject">제목</label></td>
				<td class="td_right">
					<input type="text" name="board_subject" id="board_subject" required="required">
				</td>
			</tr>
			<tr>
				<td class="td_left"><label for="board_content">내용</label></td>
				<td class="td_right">
					<textarea rows="15" cols="40" name="board_content" id="board_content" required="required"></textarea>
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="답글등록"> 
					<input type="reset" value="다시쓰기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>