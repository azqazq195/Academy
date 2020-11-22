package community.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import community.bean.CommunityDTO;
import files.bean.FilesDTO;

@Controller
public class CommunityController {
	@Autowired
	CommunityService communityService;
	
	 // 매개변수 MultipartFile의 photo는 <input type="file" name="photo"/> 태그의 name과 일치해야함
	   @RequestMapping(value = "/community/community_insert.do")
	   public ModelAndView communityWrite(HttpServletRequest request, MultipartFile photo) throws Exception {
	      request.setCharacterEncoding("UTF-8");
	      // 데이터
	      String dir = request.getSession().getServletContext().getRealPath("/storage");
	      
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
	      
	      // 글 정보 저장
	      int result1 = communityService.communityWrite(communityDTO);
	      
	      // json
	      int community_seq = 0;
	      String rt = "FAIL";   
	      if(result1 > 0) rt = "OK";
	      
	      // 글 데이터 저장이 성공한 경우, 파일 관련 데이터 저장
	      if(rt.equals("OK")) {
	         // photo는 파일이 전달되지 않으면 null
	         if(photo != null) {
	            // 전송되어온 파일 이름
	            String originname = photo.getOriginalFilename();
	            // storage 폴더에 저장된 파일 이름
	            String filename = photo.getOriginalFilename();
	            // 저장할 파일의 확장자를 원본이름에서 추출
	            int lastIndex = originname.lastIndexOf(".");
	            String filetype = originname.substring(lastIndex + 1);
	            // 파일의 크기
	            int filesize = (int)photo.getSize();
	            // 파일 복사
	            File file = new File(dir, filename);
	            FileCopyUtils.copy(photo.getInputStream(), new FileOutputStream(file));
	            
	            // dto에 저장
	            FilesDTO filesDTO = new FilesDTO();
	            filesDTO.setDir(dir);
	            filesDTO.setOriginname(originname);
	            filesDTO.setFilename(filename);
	            filesDTO.setFiletype(filetype);
	            filesDTO.setFilesize(filesize);
	            
	            // community seq 값 얻기
	            community_seq = communityService.getCommunityFirstSeq();
	            filesDTO.setCommunity_seq(community_seq);
	            
	            int result2 = communityService.filesWrite(filesDTO);
	         }      
	      }
	      // json 출력
	      JSONObject json = new JSONObject();
	      json.put("rt", rt);
	      json.put("seq", community_seq);
	      
	      // 화면 네비게이션
	      ModelAndView modelAndView = new ModelAndView();
	      modelAndView.addObject("json", json);
	      modelAndView.setViewName("community.jsp");
	       
	      return modelAndView;
	   }
	
	   
	@RequestMapping(value = "/community/community_delete.do")
	public ModelAndView communityDelete(HttpServletRequest request) throws Exception {		
		int seq = Integer.parseInt(request.getParameter("seq"));
		String user_pwd = request.getParameter("user_pwd");
		String dir = request.getSession().getServletContext().getRealPath("/storage");
		
		String rt = "FAIL";
		String filename = communityService.checkFiles(seq);
		
		// 파일이 있는지 확인
		// 커뮤니티 삭제
		// 파일 삭제
		int su1 = 0;
		int su2 = 0;
		if(filename != null){
			su1 = communityService.communityDelete(seq, user_pwd);
			su2 = communityService.filesDelete(seq, dir + "/" + filename);
		}
		
		if(su1 > 0 && su2 > 0) {
			rt = "OK";
		}
		
		// json 출력
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		json.put("seq", seq);
		
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
		String dir = request.getSession().getServletContext().getRealPath("/storage");
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		String user_name = request.getParameter("user_name");
		String user_pwd = request.getParameter("user_pwd");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		System.out.println(seq);
		System.out.println(user_name);
		System.out.println(user_pwd);
		System.out.println(email);
		System.out.println(subject);
		System.out.println(content);
		
		// DB
		CommunityDTO communityDTO = new CommunityDTO();
		communityDTO.setSeq(seq);
		communityDTO.setUser_name(user_name);
		communityDTO.setUser_pwd(user_pwd);
		communityDTO.setEmail(email);
		communityDTO.setSubject(subject);
		communityDTO.setContent(content);
		
		String rt = "FAIL";
		int community_seq = 0;
		
		// 비밀번호 확인
		
		// 글 정보 저장 
		int su1 = communityService.communityModify(communityDTO);
		// json
		if(su1 > 0) rt = "OK";
		
		// json 출력
		JSONObject json = new JSONObject();
		json.put("rt", rt);
		json.put("seq", community_seq);
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("community.jsp");
		return modelAndView;
	}
	
	@RequestMapping(value = "/community/community_list.do")
	public ModelAndView communityList(HttpServletRequest request) throws Exception {		
		List<CommunityDTO> list = communityService.communityList();
		
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
			String filename = communityService.checkFiles(seq);
			String fileURL = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + request.getContextPath()
				+ "/storage/" + filename;
			temp.put("seq",seq);
			temp.put("user_name",communityDTO.getUser_name());
			temp.put("user_pwd",communityDTO.getUser_pwd());
			temp.put("subject",communityDTO.getSubject());
			temp.put("content",communityDTO.getContent());
			temp.put("email",communityDTO.getEmail());
			temp.put("edit_date",communityDTO.getEdit_date());
			temp.put("reg_date",communityDTO.getReg_date());
			if(communityService.checkFiles(seq) != null){
				temp.put("filename", fileURL);
			} else {
				temp.put("filename", "");
			}
			array.put(temp);
		}
		
		json.put("item", array);
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("community.jsp");
		return modelAndView;
	}
	
	/*
	
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
	*/
	@RequestMapping(value = "/community/community_select.do")
	public ModelAndView communitySelect(HttpServletRequest request) throws Exception {		
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		
		CommunityDTO communityDTO = communityService.communitySelect(seq);
		
		String rt = "FAIL";
		JSONObject json = new JSONObject();
		if(communityDTO != null){
			rt = "OK";
			String filename = communityService.checkFiles(seq);
			String fileURL = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + request.getContextPath()
				+ "/storage/" + filename;
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
			temp.put("filename", fileURL);
			array.put(temp);
			json.put("item", array);
		} else {
			json.put("rt", rt);
		}
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("community.jsp");
		return modelAndView;
	}
	
}









