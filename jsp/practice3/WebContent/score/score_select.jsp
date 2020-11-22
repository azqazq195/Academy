<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="score.bean.ScoreDTO"%>
<%@page import="score.dao.ScoreDAO"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터
	String studNo = request.getParameter("studNo");
	// DB
	ScoreDAO scoreDAO = new ScoreDAO();
	ScoreDTO scoreDTO = scoreDAO.scoreSelect(studNo);
	// json
	String rt = "FAIL";
	int total = 0;
	
	if(scoreDTO != null) {
		rt = "OK";
		total = 1;
	}
	
	JSONObject json = new JSONObject();
	json.put("rt", rt);
	json.put("total", total);
	
	if(rt.equals("OK")) {
		JSONArray item = new JSONArray();	
		JSONObject temp = new JSONObject(scoreDTO);
		item.put(temp);
		json.put("item", item);
	}
	
	out.println(json);
%>
