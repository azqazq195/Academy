<%@page import="files.dao.FilesDAO"%>
<%@page import="org.json.JSONArray"%>
<%@page import="org.json.JSONObject"%>
<%@page import="community.bean.CommunityDTO"%>
<%@page import="java.util.List"%>
<%@page import="community.dao.CommunityDAO"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// DB
	CommunityDAO communityDAO = new CommunityDAO();
	List<CommunityDTO> list = communityDAO.communityList();
	// json
	String rt = "FAIL";
	int total = list.size();
	if(total > 0) {
		rt = "OK";
	}
	
	JSONObject json = new JSONObject();
	json.put("rt", rt);
	json.put("total", total);
	// json 배열
	if(total > 0) {
		JSONArray item = new JSONArray();
		for(int i=0; i<total; i++) {
			CommunityDTO communityDTO = list.get(i);
			// 파일이름 얻어오기
			FilesDAO filesDAO = new FilesDAO();
			String filename = filesDAO.checkFiles(communityDTO.getSeq());
			// 파일 URL
			String fileURL = "";
			if(filename != null) {
				fileURL = "http://192.168.0.96:8080/imageboard/storage/" + filename;
			}
			// json 객체 생성
			JSONObject temp = new JSONObject();
			temp.put("seq", communityDTO.getSeq());
			temp.put("user_name", communityDTO.getUser_name());
			temp.put("user_pwd", communityDTO.getUser_pwd());
			temp.put("email", communityDTO.getEmail());
			temp.put("subject", communityDTO.getSubject());
			temp.put("content", communityDTO.getContent());
			temp.put("reg_date", communityDTO.getReg_date());
			temp.put("edit_date", communityDTO.getEdit_date());
			temp.put("filename", fileURL);
			// json 배열에 추가
			item.put(i, temp);
		}
		// json 객체에 배열 추가
		json.put("item", item);
	}	
	out.println(json);
%> 