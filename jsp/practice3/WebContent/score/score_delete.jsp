<%@page import="org.json.JSONObject"%>
<%@page import="score.dao.ScoreDAO"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터
	String studNo = request.getParameter("studNo");	
	// DB	
	ScoreDAO scoreDAO = new ScoreDAO();
	int result = scoreDAO.scoreDelete(studNo);
	// Json
	String rt = "FAIL";
	if(result > 0) rt = "OK";
	
	JSONObject json = new JSONObject();
	json.put("rt", rt);
	out.println(json);
%>    
