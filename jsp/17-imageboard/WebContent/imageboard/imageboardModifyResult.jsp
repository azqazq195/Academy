<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(${su > 0}) {
		alert("수정 성공");
	} else {
		alert("수정 실패");
	}
	location.href = "../imageboard/imageboardView.jsp?seq=${seq}&pg=${pg}";
</script>
</head>
<body>

</body>
</html>











