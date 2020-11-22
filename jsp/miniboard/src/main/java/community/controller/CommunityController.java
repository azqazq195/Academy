package community.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import community.bean.CommunityDTO;

@Controller
public class CommunityController {
	@Autowired
	CommunityService communityService;
	
	@RequestMapping(value = "/community/community_insert.do")
	public ModelAndView communityWrite(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("UTF-8"); // 한글 설정
		// 데이터
		String user_name = request.getParameter("user_name");
		String user_pwd = request.getParameter("user_pwd");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		// DB
		CommunityDTO communityDTO = new CommunityDTO();
		communityDTO.setUser_name(user_name);
		communityDTO.setUser_pwd(user_pwd);
		communityDTO.setEmail(email);
		communityDTO.setSubject(subject);
		communityDTO.setContent(content);
		
		int su = communityService.communityWrite(communityDTO);
		// 결과 처리 : json 문서 
		String rt = null;
		if(su > 0) {
			rt = "OK";
		} else {
			rt = "FAIL";
		}
		/* json 데이터 생성
		   {"rt" : "OK"}
		*/
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("community.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/community/community_delete.do")
	public ModelAndView communityDelete(HttpServletRequest request) throws Exception {		
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		String user_pwd = request.getParameter("user_pwd");
		// DB
		int su = communityService.communityDelete(seq, user_pwd);
		// 결과값 처리 : json
		String rt = "FAIL";
		if(su > 0) {
			rt = "OK";
		}
		
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("community.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/community/community_modify.do")
	public ModelAndView communityModify(HttpServletRequest request) throws Exception {		
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
		
		int su = communityService.communityModify(communityDTO);
		
		String rt = "FAIL";
		if(su > 0) {
			rt = "OK";
		}
		
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("community.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/community/community_list.do")
	public ModelAndView communityList(HttpServletRequest request) throws Exception {		
		// DB
		List<CommunityDTO> list = communityService.communityList();
		// json
		String rt= "FAIL";
		int total = list.size();
		
		if(total > 0) {
			rt = "OK";
		}
		
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		json.put("total", total);
		
		if(total > 0) {
			JSONArray item = new JSONArray();
			
			for(int i=0; i<total; i++) {
				CommunityDTO communityDTO = list.get(i);
				
				JSONObject temp = new JSONObject();
				temp.put("seq", communityDTO.getSeq());
				temp.put("user_name", communityDTO.getUser_name());
				temp.put("user_pwd", communityDTO.getUser_pwd());
				temp.put("email", communityDTO.getEmail());
				temp.put("subject", communityDTO.getSubject());
				temp.put("content", communityDTO.getContent());
				temp.put("reg_date", communityDTO.getReg_date());
				temp.put("edit_date", communityDTO.getEdit_date());
				
				// JSONArray에 추가
				item.put(i, temp);
			}
			json.put("item", item);
		}
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("community.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/community/community_index_list.do")
	public ModelAndView communityIndexList(HttpServletRequest request) throws Exception {		
		// 데이터
		int pg = Integer.parseInt(request.getParameter("page"));
		int size = Integer.parseInt(request.getParameter("size"));
		
		// DB 
		// 1페이지당 1~15
		int endNum = pg * size;					// 1 * 15 = 15
		int startNum = endNum - (size - 1);		// 15 - (15 -1) = 1
		
		List<CommunityDTO> list = communityService.communityIndexList(startNum, endNum);
		
		// json
		String rt= "FAIL";
		int total = list.size();
		
		if(total > 0) {
			rt = "OK";
		}
		
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		json.put("total", total);
		
		if(total > 0) {
			JSONArray item = new JSONArray();
			
			for(int i=0; i<total; i++) {
				CommunityDTO communityDTO = list.get(i);
				
				JSONObject temp = new JSONObject();
				temp.put("seq", communityDTO.getSeq());
				temp.put("user_name", communityDTO.getUser_name());
				temp.put("user_pwd", communityDTO.getUser_pwd());
				temp.put("email", communityDTO.getEmail());
				temp.put("subject", communityDTO.getSubject());
				temp.put("content", communityDTO.getContent());
				temp.put("reg_date", communityDTO.getReg_date());
				temp.put("edit_date", communityDTO.getEdit_date());
				
				// JSONArray에 추가
				item.put(i, temp);
			}
			json.put("item", item);
		}
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("community.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/community/community_select.do")
	public ModelAndView communitySelect(HttpServletRequest request) throws Exception {		
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		// DB
		CommunityDTO communityDTO = communityService.communitySelect(seq);
		// json
		String rt= "FAIL";
		int total = 0;
		
		if(communityDTO != null) {
			rt = "OK";
			total = 1;
		}
		
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		json.put("total", total);
		
		if(total > 0) {
			JSONArray item = new JSONArray();		
				
			JSONObject temp = new JSONObject();
			temp.put("seq", communityDTO.getSeq());
			temp.put("user_name", communityDTO.getUser_name());
			temp.put("user_pwd", communityDTO.getUser_pwd());
			temp.put("email", communityDTO.getEmail());
			temp.put("subject", communityDTO.getSubject());
			temp.put("content", communityDTO.getContent());
			temp.put("reg_date", communityDTO.getReg_date());
			temp.put("edit_date", communityDTO.getEdit_date());
				
			// JSONArray에 추가
			item.put(0, temp);
			
			json.put("item", item);
		}
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("community.jsp");
		return modelAndView;
	}
}









