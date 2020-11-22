<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#passForm {
	width: 400px;
	margin: auto;
	border: 1px solid lightgray;
}
</style>
</head>
<body>
	<div id="passForm">
		<form action="boardDeletePro.do" method="post">
			<input type="hidden" name="page" value="${param.page}">
			<input type="hidden" name="board_num" value="${param.board_num}">
			<table>
				<tr>
					<td>글 비밀번호 : </td>
					<td><input type="password" name="pw"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="삭제">
						<input type="button" value="돌아가기" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>