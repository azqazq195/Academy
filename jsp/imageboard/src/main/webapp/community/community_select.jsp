<%@page import="files.dao.FilesDAO"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="community.bean.CommunityDTO"%>
<%@page import="community.dao.CommunityDAO"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 데이터
	int seq = Integer.parseInt(request.getParameter("seq"));
	// DB
	CommunityDAO communityDAO = new CommunityDAO();
	CommunityDTO communityDTO = communityDAO.communitySelect(seq);
	// json
	String rt = "FAIL";
	int total = 0;
	if(communityDTO != null) {
		rt = "OK";
		total = 1;
	}
	
	JSONObject json = new JSONObject();
	json.put("rt", rt);
	json.put("total", total);
	
	if(rt.equals("OK")) {
		JSONArray item = new JSONArray();
		JSONObject temp = new JSONObject();
		// 파일이름 가져오기
		FilesDAO filesDAO = new FilesDAO();
		String filename = filesDAO.checkFiles(communityDTO.getSeq());
		// 파일 URL
		String fileURL = "";
		if(filename != null) {
			fileURL = request.getScheme() + "://" + request.getServerName()
				    + ":" + request.getServerPort() + request.getContextPath() 
					+ "/storage/" + filename;			
		}
		temp.put("seq", communityDTO.getSeq());
		temp.put("user_name", communityDTO.getUser_name());
		temp.put("user_pwd", communityDTO.getUser_pwd());
		temp.put("email", communityDTO.getEmail());
		temp.put("subject", communityDTO.getSubject());
		temp.put("content", communityDTO.getContent());
		temp.put("reg_date", communityDTO.getReg_date());
		temp.put("edit_date", communityDTO.getEdit_date());
		temp.put("filename", fileURL);
		
		item.put(0, temp);
		json.put("item", item);
	}
	out.println(json);
%>    
