<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="score.bean.ScoreDTO"%>
<%@page import="java.util.List"%>
<%@page import="score.dao.ScoreDAO"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// DB
	ScoreDAO scoreDAO = new ScoreDAO();
	List<ScoreDTO> list = scoreDAO.scoreList();
	// json
	String rt = "FAIL";
	int total = list.size();
	
	if(total > 0) {
		rt = "OK";	
	}
	
	JSONObject json = new JSONObject();
	json.put("rt", rt);
	json.put("total", total);
	
	if(rt.equals("OK")) {
		json.put("item", list);
	}
	
	out.println(json);
%>
