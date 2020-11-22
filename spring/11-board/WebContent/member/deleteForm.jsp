<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(confirm("회원 탈퇴, 확실합니까?")) {
		location.href = "delete.jsp";
	} else {
		location.href = "../main/index.jsp";
	}
</script>
</head>
<body>

</body>
</html>