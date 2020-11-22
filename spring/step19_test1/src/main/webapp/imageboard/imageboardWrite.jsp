<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(${su > 0}) {
		alert("작성하신 글을 저장하였습니다.");
		location.href = "imageboardList?pg=1";
	} else {
		alert("작성하신 글을 저장하지 못하였습니다.");
		location.href = "imageboardWriteForm";
	}
</script>
</head>
<body>
<%--
<p>파일 이름 : ${dto.image1}</p>
<p>상품명 : ${dto.imageName}</p>
<img alt="" src="../storage/${dto.image1}">
<!-- 새로 고침을 해야 이미지를 볼수 있지만, 정식 서버에서는 제대로 동작함. -->
 --%>
</body>
</html>