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
	CommunityDAO communityDAO = new CommunityDAO();
	FilesDAO filesDAO = new FilesDAO();
	List<CommunityDTO> list = communityDAO.communityList();
	
	int total = list.size();
	String rt = "FAIL";
	if(total != 0){
		rt = "OK";
	}
	
	//json 출력
	JSONObject json = new JSONObject();
	json.put("rt", rt);
	json.put("total", total);
	JSONArray array = new JSONArray();
	
	for(CommunityDTO communityDTO : list){
		JSONObject temp = new JSONObject();
		int seq = communityDTO.getSeq();
		temp.put("seq",seq);
		temp.put("user_name",communityDTO.getUser_name());
		temp.put("user_pwd",communityDTO.getUser_pwd());
		temp.put("subject",communityDTO.getSubject());
		temp.put("content",communityDTO.getContent());
		temp.put("email",communityDTO.getEmail());
		temp.put("edit_date",communityDTO.getEdit_date());
		temp.put("reg_date",communityDTO.getReg_date());
		if(filesDAO.getFileName(seq) != null){
			temp.put("filename", "http://192.168.0.123:8088/imageboard/storage/" + filesDAO.getFileName(seq));
		} else {
			temp.put("filename", "");
		}
		array.put(temp);
	}
	
	json.put("item", array);
	out.println(json);
%>
