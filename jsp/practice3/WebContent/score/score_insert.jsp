<%@page import="org.json.JSONObject"%>
<%@page import="score.dao.ScoreDAO"%>
<%@page import="score.bean.ScoreDTO"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");  // 한글 설정
	// 데이터
	String studNo = request.getParameter("studNo");
	String name = request.getParameter("name");
	int kor = Integer.parseInt(request.getParameter("kor"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	int mat = Integer.parseInt(request.getParameter("mat"));
	int tot = kor + eng + mat;
	double avg = (double)tot / 3;	
	// DB
	ScoreDTO scoreDTO = new ScoreDTO();
	scoreDTO.setStudNo(studNo);
	scoreDTO.setName(name);
	scoreDTO.setKor(kor);
	scoreDTO.setEng(eng);
	scoreDTO.setMat(mat);
	scoreDTO.setTot(tot);
	scoreDTO.setAvg(avg);
	
	ScoreDAO scoreDAO = new ScoreDAO();
	int result = scoreDAO.scoreWrite(scoreDTO);
	// Json
	String rt = "FAIL";
	if(result > 0) rt = "OK";
	
	JSONObject json = new JSONObject();
	json.put("rt", rt);
	out.println(json);
%>
