<%@page import="files.dao.FilesDAO"%>
<%@page import="org.json.JSONArray"%>
<%@page import="community.bean.CommunityDTO"%>
<%@page import="java.util.List"%>
<%@page import="community.dao.CommunityDAO"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	int seq = Integer.parseInt(request.getParameter("seq"));
	
	CommunityDAO communityDAO = new CommunityDAO();
	FilesDAO filesDAO = new FilesDAO();
	
	CommunityDTO communityDTO = communityDAO.communitySelect(seq);
	
	String rt = "FAIL";
	JSONObject json = new JSONObject();
	if(communityDTO != null){
		rt = "OK";
		
		//json 출력
		json.put("rt", rt);
		JSONArray array = new JSONArray();
		
		JSONObject temp = new JSONObject();
		temp.put("seq",seq);
		temp.put("user_name",communityDTO.getUser_name());
		temp.put("user_pwd",communityDTO.getUser_pwd());
		temp.put("subject",communityDTO.getSubject());
		temp.put("content",communityDTO.getContent());
		temp.put("email",communityDTO.getEmail());
		temp.put("edit_date",communityDTO.getEdit_date());
		temp.put("reg_date",communityDTO.getReg_date());
		String fileURL = request.getScheme() + "://" + request.getServerName()
						+ ":" + request.getServerPort() + request.getContextPath()
						+ "/storage/" + filesDAO.getFileName(seq);
		temp.put("filename", fileURL);
		array.put(temp);
		
		json.put("item", array);
		out.println(json);
	} else {
		json.put("rt", rt);
		out.println(json);
	}
	
	
%>
