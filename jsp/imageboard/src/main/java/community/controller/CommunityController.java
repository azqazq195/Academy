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
	
	// 매개변수 MultipartFile photo는 <input type="file" name="photo"/> 태그의 name과 일치해야함
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
		int su1 = communityService.communityWrite(communityDTO);
		// json
		int community_seq = 0;
		String rt = "FAIL";	
		if(su1 > 0) rt = "OK";
		
		// 글 데이터 저장이 성공한 경우, 파일 관련 데이터 저장
		if(rt.equals("OK")) {
			// photo는 파일이 전달되지 않으면, null임
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
				FileCopyUtils.copy(photo.getInputStream(), 
						new FileOutputStream(file));
				
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
				
				int su2 = communityService.filesWrite(filesDTO);	
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
		// 데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		String user_pwd = request.getParameter("user_pwd");
		// 실제 폴더 위치
		String dir = request.getSession().getServletContext().getRealPath("/storage");
		// db
		int su = communityService.communityDelete(seq, user_pwd);
		
		// json
		String rt = "FAIL";
		if(su > 0) rt = "OK";
		
		// 게시판 글을 지운후, 파일 삭제
		if(rt.equals("OK")) {
			// 파일이 있는 지 검사
			String filename = communityService.checkFiles(seq);
			
			if(filename != null) { // 파일이 있으면
				int su2 = communityService.filesDelete(seq, dir + "/" + filename);
			}
		}
		// json 출력
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
		
		// json
		String rt = "FAIL";
		if(su > 0) rt = "OK";
		
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
				String filename = communityService.checkFiles(communityDTO.getSeq());
				// 파일 URL
				String fileURL = "";
				if(filename != null) {
					fileURL = request.getScheme() + "://" + request.getServerName()
						+ ":" + request.getServerPort() + request.getContextPath()
						+ "/storage/" + filename;
					//fileURL = "http://192.168.0.96:8080/imageboard/storage/" + filename;
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
				
				// 파일이름 얻어오기
				String filename = communityService.checkFiles(communityDTO.getSeq());
				// 파일 URL
				String fileURL = "";
				if(filename != null) {
					fileURL = request.getScheme() + "://" + request.getServerName()
						+ ":" + request.getServerPort() + request.getContextPath()
						+ "/storage/" + filename;
					//fileURL = "http://192.168.0.96:8080/imageboard/storage/" + filename;
				}
				
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
			String filename = communityService.checkFiles(communityDTO.getSeq());
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
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("json", json);
		modelAndView.setViewName("community.jsp");
		return modelAndView;
	}

}









