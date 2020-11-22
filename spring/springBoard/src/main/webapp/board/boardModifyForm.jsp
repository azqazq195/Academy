<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../script/boardScript.js?v=2"></script>
<script type="text/javascript">
	function reset1() {
		var frm = document.boardModifyForm;		
		frm.subject.value="";
		frm.content.value="";
	}
</script>
</head>
<body>
	<form action="boardModify.do" method="post" name="boardModifyForm">
		<input type="hidden" name="seq" value="${seq}">
		<input type="hidden" name="pg" value="${pg}">
		
		<table border="1">
			<tr>
				<th width="50">제목</th>
				<td><input type="text" name="subject" size="45" 
						value="${boardDTO.getSubject()}"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="15" cols="48" 
						name="content">${boardDTO.getContent()}</textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="button" value="글수정" onclick="checkBoardModify()">
					<input type="button" value="다시작성" onclick="reset1()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>

