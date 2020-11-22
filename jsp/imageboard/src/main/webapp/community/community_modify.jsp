<%@page import="org.json.JSONObject"%>
<%@page import="community.dao.CommunityDAO"%>
<%@page import="community.bean.CommunityDTO"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	// 데이터 
	int seq = Integer.parseInt(request.getParameter("seq"));
	String user_name = request.getParameter("user_name");
	String user_pwd = request.getParameter("user_pwd");
	String email = request.getParameter("email");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	// DB
	CommunityDTO communityDTO = new CommunityDTO();
	communityDTO.setSeq(seq);
	communityDTO.setUser_name(user_name);
	communityDTO.setUser_pwd(user_pwd);
	communityDTO.setEmail(email);
	communityDTO.setSubject(subject);
	communityDTO.setContent(content);
	
	CommunityDAO communityDAO = new CommunityDAO();
	int su = communityDAO.communityModify(communityDTO);
	
	// json
	String rt = "FAIL";
	if(su > 0) rt = "OK";
	
	JSONObject json = new JSONObject();
	json.put("rt", rt);
	out.println(json);	
%>
