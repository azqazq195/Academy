<%@page import="member.dao.MemberDAO"%>
<%@page import="member.bean.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 한글 설정
	request.setCharacterEncoding("utf-8");
	// 데이터 처리
	String name = request.getParameter("name");
	//String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String gender = request.getParameter("gender");
	String email1 = request.getParameter("email1");
	String email2 = request.getParameter("email2");
	String tel1 = request.getParameter("tel1");
	String tel2 = request.getParameter("tel2");
	String tel3 = request.getParameter("tel3");
	String addr = request.getParameter("addr");
	// DB 처리
	MemberDTO memberDTO = new MemberDTO();
	memberDTO.setName(name);
	memberDTO.setId((String)session.getAttribute("memId"));
	memberDTO.setPwd(pwd);
	memberDTO.setGender(gender);
	memberDTO.setEmail1(email1);
	memberDTO.setEmail2(email2);
	memberDTO.setTel1(tel1);
	memberDTO.setTel2(tel2);
	memberDTO.setTel3(tel3);
	memberDTO.setAddr(addr);
	
	MemberDAO memberDAO = new MemberDAO();
	int su = memberDAO.modify(memberDTO);
	//System.out.println("su = " + su);
	//System.out.println("id = " + id);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	alert(<%= su > 0%>)
	if(<%= su > 0%>) {
		alert("회원 정보 수정 성공");
	} else {
		alert("회원 정보 수정 실패");
	}
	location.href = "../main/index.jsp";
</script>
</head>
<body>

</body>
</html>







